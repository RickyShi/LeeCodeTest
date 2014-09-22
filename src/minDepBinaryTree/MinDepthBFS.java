package minDepBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class MinDepthBFS {
	public int minDepth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		if (root == null) {
			return 0;
		}
		// queue.add(root);
		queue.offer(root);
		int h = 1;
		int num = 1;
		while (!queue.isEmpty()) {
			int addNum = 0;
			for (int i=0;i<num;i++){
				// TreeNode node = queue.remove();
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return h;
				}
				if (node.left != null) {
					// queue.add(node.left);
					queue.offer(node.left);
					addNum++;
				}
				if (node.right != null) {
					// queue.add(node.right);
					queue.offer(node.right);
					addNum++;
				}
			}
			num = addNum;
			h++;
		}
		return h;
	}

}
