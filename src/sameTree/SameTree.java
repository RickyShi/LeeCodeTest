package sameTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if ((p == null && q != null) || (q == null && p != null)) {
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			boolean leftIsSame = isSameTree(p.left, q.left);
			boolean rightIsSame = isSameTree(p.right, q.right);
			return leftIsSame && rightIsSame;
		}
	}
}
