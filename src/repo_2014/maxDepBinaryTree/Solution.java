package repo_2014.maxDepBinaryTree;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftH = maxDepth(root.left);
		int rightH = maxDepth(root.right);
		return (leftH > rightH) ? (leftH + 1) : (rightH + 1);

	}
}
