package symmetricTree;

public class SymmetricTreeRec {
	/**
	 * 递归解法：
	 *
	 * 其中左子树和右子树对称的条件：
	 * 两个节点值相等，或者都为空
	 * 左节点的左子树和右节点的右子树对称
	 * 左节点的右子树和右节点的左子树对称
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSym(root.left, root.right);
	}

	private boolean isSym(TreeNode l, TreeNode r) {
		if ((l == null && r != null) || (l != null && r == null)) {
			return false;
		}
		if (l == null && r == null) {
			return true;
		}
		if (l.val != r.val) {
			return false;
		}
		return isSym(l.left, r.right) && isSym(l.right, r.left);
	}

}
