package repo_2014.binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Not Recursive way. Use stack.
 *
 * @author Ricky
 *
 */
public class BinaryTreePostOrderTraversalNotRec {
	/**
	 * Method1
	 *
	 * @param root
	 * @return
	 */
	public static List<Integer> postorderTraversalNotRec(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		if (root == null) {
			return list;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode prev = null;
		while (!stack.empty()) {
			TreeNode curr = stack.peek();

			// go down the tree.
			// check if current node is leaf, if so, process it and pop stack,
			// otherwise, keep going down
			if (prev == null || prev.left == curr || prev.right == curr) {
				// prev == null is the situation for the root node
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					list.add(curr.val);
				}

				// go up the tree from left node
				// need to check if there is a right child
				// if yes, push it to stack
				// otherwise, process parent and pop stack
			} else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
					list.add(curr.val);
				}

				// go up the tree from right node
				// after coming back from right node, process parent node and
				// pop stack.
			} else if (curr.right == prev) {
				stack.pop();
				list.add(curr.val);
			}

			prev = curr;
		}

		return list;
	}

	// ------------------------------------------------------------------------------

	/**
	 * Method 2
	 *
	 * @author m4
	 *
	 */

	public static List<Integer> postorderTraversalLeeCodeSample(TreeNode root) {
		class TreeNodeFlag {
			TreeNode node;
			boolean flag;

			TreeNodeFlag(TreeNode node) {
				this.node = node;
				this.flag = false;
			}
		}

		List<Integer> result = new LinkedList<Integer>();
		Stack<TreeNodeFlag> stack = new Stack<TreeNodeFlag>();
		if (root == null) {
			return result;
		}
		stack.push(new TreeNodeFlag(root));
		while (!stack.isEmpty()) {
			TreeNodeFlag flagNode = stack.pop();
			if (flagNode.flag) {
				result.add(flagNode.node.val);
				continue;
			}
			flagNode.flag = true;
			stack.push(flagNode);
			if (flagNode.node.right != null) {
				stack.push(new TreeNodeFlag(flagNode.node.right));
			}
			if (flagNode.node.left != null) {
				stack.push(new TreeNodeFlag(flagNode.node.left));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.right = t2;
		// t1.right = t3;
		t2.left = t3;
		t2.right = t4;
		List<Integer> l = postorderTraversalNotRec(t1);
		for (int i : l) {
			System.out.print(i + ",");
		}
		System.out.print("---------------------------------------");
		List<Integer> l2 = postorderTraversalLeeCodeSample(t1);
		for (int i : l2) {
			System.out.print(i + ",");
		}

	}
}
