package reverseLinkedList;

import sortList.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 *
 * @author Ricky
 *
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n) {
			return head;
		}
		int i = 1;
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode fakeHead = pre;
		while (i < m) {
			pre = pre.next;
			i++;
		}
		ListNode cur = pre.next;
		while (i < n) {
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = pre.next;
			pre.next = next;
			i++;
		}
		return fakeHead.next;
	}
}

