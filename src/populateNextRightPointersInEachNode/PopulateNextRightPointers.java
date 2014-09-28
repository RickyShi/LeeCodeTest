package populateNextRightPointersInEachNode;

/**
 * Definition for binary tree with next pointer. public class TreeLinkNode {
 *
 * int val;
 *
 * TreeLinkNode left, right, next;
 *
 * TreeLinkNode(int x) { val = x; }
 *
 * }
 */
public class PopulateNextRightPointers {
	public void connect(TreeLinkNode root) {
		// reference to same root
		// the change of the value will affect these three var together
		TreeLinkNode head = root;
		TreeLinkNode tail = root;
		if (root == null) {
			return;
		}

		int maxNum = 1;
		int count = 0;
		while (head != null) {
			if (head.left != null) {
				tail.next = head.left;
				tail = head.left;
			}
			if (head.right != null) {
				tail.next = head.right;
				tail = head.right;
			}
			count++;
			if (count == maxNum) {
				TreeLinkNode newHead = head.next;
				head.next = null;
				head = newHead;
				maxNum *= 2;
				count = 0;
			} else {
				head = head.next;
			}
		}
	}
}
