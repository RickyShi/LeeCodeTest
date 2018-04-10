package repo_2014.reorderList;

import repo_2014.sortList.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 * Linked List
 *
 * @author Ricky
 *
 */
public class ReorderList {
	/**
	 * 1. split the list to two parts
	 * 2. reverse the second list
	 * 3. merge two lists
	 *
	 * @param head
	 */

	public static void reorderList(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			// while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			}
		if (slow != null) {
			// reverse second list
			// new head will be pre
			ListNode cur = slow.next;
			ListNode pre = null;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			// first list
			slow.next = null;
			slow = head;

			while (slow != null && pre != null) {
				ListNode next1 = slow.next;
				slow.next = pre;
				ListNode next2 = pre.next;
				pre.next = next1;
				slow = pre.next;
				pre = next2;
			}

			if (slow == null) {
				slow = pre;
			} else if (pre == null) {
				pre = slow;
			}
		}
	}

	public static void printList(ListNode n) {
		System.out.println("------");
		while (n != null) {
			System.out.print(n.val);
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		System.out.println("raw");
		printList(n1);

		reorderList(n1);
		System.out.println("reorder");
		printList(n1);
	}

}
