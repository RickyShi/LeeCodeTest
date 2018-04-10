package repo_2014.mergeSortedList;

import repo_2014.sortList.ListNode;

/**
 * The key to solve the problem is defining a fake head. Then compare the first
 * elements from each list. Add the smaller one to the merged list. Finally,
 * when one of them is empty, simply append it to the merged list, since it is
 * already sorted.
 * 
 * @author Ricky
 * 
 */
public class MergeSortedList {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode fakeHead = new ListNode(0);
		ListNode preNode = fakeHead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				preNode.next = l1;
				l1 = l1.next;
			} else {
				preNode.next = l2;
				l2 = l2.next;
			}
			preNode = preNode.next;
		}

		if (l1 != null) {
			preNode.next = l1;
		}
		if (l2 != null) {
			preNode.next = l2;
		}

		return fakeHead.next;
	}
}
