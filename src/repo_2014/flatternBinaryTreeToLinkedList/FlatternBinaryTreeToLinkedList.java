package repo_2014.flatternBinaryTreeToLinkedList;

import java.util.Stack;

import repo_2014.binaryTreeTraversal.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 * 1
 * / \
 * 2 5
 * / \ \
 * 3 4 6
 * The flattened tree should look like:
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 *
 * @author Ricky
 *
 */
public class FlatternBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.empty()) {

			if (p.right != null) {
				stack.push(p.right);
			}

			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.empty()) {
				TreeNode temp = stack.pop();
				p.right = temp;
			}
			p = p.right;
		}
	}

		TreeNode lastVisited = null;
	    public void flattenRec(TreeNode root) {
			if (root == null) {
				return;
			}
			TreeNode rightSaved = root.right;
			if (lastVisited != null) {
				lastVisited.left = null;
				lastVisited.right = root;
			}
			lastVisited = root;
			flattenRec(root.left);
			flattenRec(rightSaved);
	    }
}