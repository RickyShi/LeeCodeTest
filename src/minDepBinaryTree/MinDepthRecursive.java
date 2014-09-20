package minDepBinaryTree;


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

public class MinDepthRecursive {
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			int leftH = minDepth(root.left);
			int rightH = minDepth(root.right);
			return (leftH < rightH) ? (leftH + 1) : (rightH + 1);
		}
	}
}
