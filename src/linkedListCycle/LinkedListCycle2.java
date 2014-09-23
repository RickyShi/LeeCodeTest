package linkedListCycle;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				fast = head;
				while (fast != null) {
					if (fast == slow) {
						return slow;
					}
					fast = fast.next;
					slow = slow.next;
				}
			}
		}
		return null;
	}
}
