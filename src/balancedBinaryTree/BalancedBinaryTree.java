package balancedBinaryTree;


/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 *
 * @author Ricky
 *
 */
public class BalancedBinaryTree {
	/**
	 * Recursive way
	 *
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		if (getTreeDep(root) == -1) {
			return false;
		}
		return true;
	}

	private int getTreeDep(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getTreeDep(root.left);
		int right = getTreeDep(root.right);

		if (left == -1 || right == -1) {
			return -1;
		}

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		return Math.max(left, right) + 1;

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
