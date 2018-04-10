package repo_2014.convertSortedListToBinarySearchTree;

import repo_2014.sortList.ListNode;
import repo_2014.binaryTreeTraversal.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * @author Ricky
 *
 */
public class ConvertSortedListToBinarySearchTree {
	/**
	 * Not Like Sorted Array, we use Bottom-Up
	 */
	private ListNode h;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

	// build tree bottom-up
	// left-mid(parent)-right
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end) {
			return null;
		}

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
	}
}
