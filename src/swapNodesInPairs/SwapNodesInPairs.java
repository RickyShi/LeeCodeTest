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
 *         4. Swap ListNode Fake Head
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

	/**
	 * 这道题考察了基本的链表操作，注意当改变指针连接时，要用一个临时指针指向原来的next值，否则链表丢链，无法找到下一个值。
	 * 
	 * 本题的解题方法是：
	 * 
	 * 需要运用fakehead来指向原指针头，防止丢链，用两个指针，ptr1始终指向需要交换的pair的前面一个node，
	 * ptr2始终指向需要交换的pair的第一个node。
	 * 
	 * 然后就是进行链表交换。
	 * 
	 * NO NEED TO USE
	 * NEXTSTART---------------------------------------------------------
	 * 需要用一个临时指针nextstart， 指向下一个需要交换的pair的第一个node，保证下一次交换的正确进行。
	 * ------------------------------------------------------------------------
	 *
	 * 然后就进行正常的链表交换，和指针挪动就好。
	 * 
	 * 当链表长度为奇数时，ptr2.next可能为null；
	 * 
	 * 当链表长度为偶数时，ptr2可能为null。
	 * 
	 * 所以把这两个情况作为终止条件，在while判断就好，最后返回fakehead.next。
	 * 
	 * @param head
	 * @return
	 */
	public ListNode swapPairsFakeHead(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fakehead = new ListNode(-1);
		fakehead.next = head;

		ListNode ptr1 = fakehead;
		ListNode ptr2 = head;

		while (ptr2 != null && ptr2.next != null) {
			ptr1.next = ptr2.next;
			ptr2.next = ptr2.next.next;
			ptr1.next.next = ptr2;
			ptr1 = ptr2;
			ptr2 = ptr2.next;
		}
		/**
		 * while (ptr2 != null && ptr2.next != null) {
		 *
		 * ListNode nextstart = ptr2.next.next;
		 * ptr2.next.next = ptr2;
		 * ptr1.next = ptr2.next;
		 * ptr2.next = nextstart;
		 * ptr1 = ptr2;
		 * ptr2 = ptr2.next;
		 * }
		 **/
		return fakehead.next;
	}
}
