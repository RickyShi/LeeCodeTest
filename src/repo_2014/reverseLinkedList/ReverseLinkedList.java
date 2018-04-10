
package repo_2014.reverseLinkedList;
import repo_2014.sortList.ListNode;

	public class ReverseLinkedList {
		public static ListNode reverseList(ListNode head) {
			ListNode pre = null;
			ListNode cur = head;
			while (cur != null) {
				ListNode next = cur.next;
				cur.next = pre;
				pre = cur;
				cur = next;
			}
			return pre;
		}

		public static ListNode reverseListRec(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode next = head.next;
			// new Head here
			ListNode newHead = reverseListRec(next);
			head.next.next = head;
			head.next = null;
			head = next;
			return newHead;
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


			System.out.println("reverse");
			// printList(reverseList(n1));
			printList(reverseListRec(n1));
			// printList(n4);
		}
	}


