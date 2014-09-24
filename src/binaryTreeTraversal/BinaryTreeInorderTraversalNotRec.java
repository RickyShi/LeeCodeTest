package binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Not recursive way. Using stack to put the root
 *
 * @author Ricky
 *
 */
public class BinaryTreeInorderTraversalNotRec {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		// 用一个boolean变量flag
		// flag = false表示顶点刚被push进去，需要首先处理左子树；
		// flag=true表示左子树都已经处理完了，可以处理右子树。
		// 栈中保存的元素都是栈底那个元素的左子树。
		boolean flag = true;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.peek();
			if (flag) {
				// push left subtree left nodes
				if (treeNode.left != null) {
					stack.push(treeNode.left);
					treeNode = treeNode.left;
				} else {
					flag = false;
				}
				// deal with root and right of the sub tree
			} else {
				list.add(stack.pop().val);
				if (treeNode.right != null) {
					stack.push(treeNode.right);
					flag = true;
				}
			}

		}
		return list;
	}
}
