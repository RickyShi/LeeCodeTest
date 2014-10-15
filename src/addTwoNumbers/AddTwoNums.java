package addTwoNumbers;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author Ricky
 * 
 */
 class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class AddTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;
		ListNode node1 = l1;
		ListNode node2 = l2;
		// carry means 进位
		int carry = 0;

		while (node1 != null || node2 != null) {
			int val1 = node1 == null ? 0 : node1.val;
			int val2 = node2 == null ? 0 : node1.val;
			int sum = val1 + val2 + carry;
			carry = sum / 10;
			ListNode newNode = node1 == null ? node2 : node1;
			newNode.val = sum % 10;
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
		}
		// we still have carry on the last number
		if (carry > 0) {
			tail.next = new ListNode(carry);
			tail = tail.next;
		}

		if (tail != null) {
			tail.next=null;
		}
		return head;
	}
}
