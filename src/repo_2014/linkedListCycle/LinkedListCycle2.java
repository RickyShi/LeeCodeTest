package repo_2014.linkedListCycle;

/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * @author Ricky
 * 
 */
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
