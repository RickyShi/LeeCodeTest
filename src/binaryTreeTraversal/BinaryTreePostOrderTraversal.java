package binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * recursive
 *
 * @author Ricky
 *
 */
public class BinaryTreePostOrderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		return generateTree(root, list);
	}

	private List<Integer> generateTree(TreeNode root, List<Integer> list) {
		if (root == null) {
			return list;
		}

		generateTree(root.left, list);
		generateTree(root.right, list);
		list.add(root.val);

		return list;
	}
}
