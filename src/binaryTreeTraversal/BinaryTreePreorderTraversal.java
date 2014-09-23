package binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * recursive
 * 
 * @author Ricky
 * 
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		return generateTree(root, list);
	}

	private List<Integer> generateTree(TreeNode root, List<Integer> list) {
		if (root == null) {
			return list;
		}

		list.add(root.val);
		generateTree(root.left, list);
		generateTree(root.right, list);

		return list;
	}
}
