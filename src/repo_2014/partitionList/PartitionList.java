package repo_2014.partitionList;

import repo_2014.sortList.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @author Ricky
 *
 */
public class PartitionList {
	/**
	 * split the origin list into two lists
	 *
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode fakeHeadL = new ListNode(-1);
		ListNode fakeHeadR = new ListNode(-1);
		ListNode l = fakeHeadL;
		ListNode r = fakeHeadR;
		ListNode cur = head;

		while (cur != null) {
			if (cur.val < x) {
				l.next = new ListNode(cur.val);
				l = l.next;
			} else {
				r.next = new ListNode(cur.val);
				r = r.next;
			}
			cur = cur.next;
		}
		l.next = fakeHeadR.next;
		return fakeHeadL.next;
	}

	public ListNode partition2(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode fakeHead1 = new ListNode(0);
		ListNode fakeHead2 = new ListNode(0);
		fakeHead1.next = head;

		ListNode p = head;
		ListNode prev = fakeHead1;
		ListNode p2 = fakeHead2;

		while (p != null) {
			if (p.val < x) {
				p = p.next;
				prev = prev.next;
			} else {

				p2.next = p;
				prev.next = p.next;

				p = prev.next;
				p2 = p2.next;
			}
		}

		// close the list
		p2.next = null;

		prev.next = fakeHead2.next;

		return fakeHead1.next;
	}
}
