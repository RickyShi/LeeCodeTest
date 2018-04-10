package repo_2014.binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraverseNotRecSimple {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			list.add(treeNode.val);
			if (treeNode.right != null) {
				stack.push(treeNode.right);
			}

			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
		return list;
	}
}
