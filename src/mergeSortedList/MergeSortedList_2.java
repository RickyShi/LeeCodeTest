package mergeSortedList;

import sortList.ListNode;

public class MergeSortedList_2 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return (l1 == null) ? l2 : l1;
		}
		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		// copy head to tmp
		ListNode tmp = head;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				// first round to correct head's next reference
				tmp.next = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				l2 = l2.next;
			}
			tmp = tmp.next;
		}
		if (l1 != null) {
			tmp.next = l1;
		}
		if (l2 != null) {
			tmp.next = l2;
		}
		return head;
	}
}
