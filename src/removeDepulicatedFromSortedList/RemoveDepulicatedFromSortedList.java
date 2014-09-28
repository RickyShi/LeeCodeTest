package removeDepulicatedFromSortedList;


/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class RemoveDepulicatedFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode pre = head;
		ListNode next = head.next;

		while (next != null) {
			if (next.val != pre.val) {
				pre = next;
				next = next.next;
			} else {
				pre.next = next.next;
				next = pre.next;
			}
		}
		return head;
	}
}
