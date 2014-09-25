package binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
/**
 * same thought from InorderTraverseNotRec
 * @author Ricky
 *
 */
public class BinaryTreePreorderTraverseNotRecComplex {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean flag = false;
		if (root == null) {
			return list;
		}
		stack.push(root);
		list.add(root.val);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.peek();
			if (!flag) {
				if (treeNode.left != null) {
					stack.push(treeNode.left);
					list.add(stack.peek().val);
				} else {
					flag = true;
				}
			} else {
				stack.pop();
				if (treeNode.right!=null){
					stack.push(treeNode.right);
					list.add(stack.peek().val);
					flag=false;
				}
			}
		}
		return list;
	}
}
