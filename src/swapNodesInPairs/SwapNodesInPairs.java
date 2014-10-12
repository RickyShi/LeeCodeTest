package swapNodesInPairs;

import sortList.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @author Ricky
 * 
 *         1. swap listNode
 *         2. Recursive
 *         3. swap value
 */
public class SwapNodesInPairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		ListNode cur = head, l = head, r = head.next;
		while (cur != null && cur.next != null) {
			l.next = r.next;
			r.next = l;
			cur = cur.next;
			if (cur != null && cur.next != null) {
				l.next = cur.next;
				l = cur;
				r = cur.next;
			}
		}
		return newHead;
	}

	public ListNode swapPairsRecursive(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		ListNode nextPair = head.next.next;
		head.next.next = head;
		head.next = swapPairs(nextPair);
		return newHead;
	}

	public ListNode swapPairsValues(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode pro = head.next;
		ListNode tmp = pro;

		while (tmp.next != null) {
			tmp = tmp.next;
			if (tmp.next != null) {
				int temp = pro.val;
				pro.val = pre.val;
				pre.val = temp;
				pro = pro.next.next;
				pre = pre.next.next;
				tmp = tmp.next;
			}
		}
		if (tmp.next == null) {
			int temp = pro.val;
			pro.val = pre.val;
			pre.val = temp;
		}
		return head;
	}
}
