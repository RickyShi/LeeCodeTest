package repo_2014.removeDepulicatedFromSortedList;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */

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
