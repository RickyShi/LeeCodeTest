package repo_2014.removeNthNodeFromEndOfList;

import repo_2014.sortList.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author Ricky
 *
 */
public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode end = head, start = head;
		for (int i = 0; i < n; i++) {
			if (end == null) {
				return null;
			}
			end = end.next;
		}
		// case of removing the head node
		if (end == null) {
			head = head.next;
			return head;
		}
		while (end.next != null) {
			start = start.next;
			end = end.next;
		}
		start.next = start.next.next;
		return head;
	}
}
