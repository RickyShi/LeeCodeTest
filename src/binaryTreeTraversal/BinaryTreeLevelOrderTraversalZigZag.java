package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalZigZag {
	public List<List<Integer>> levelOrderZigZag(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> rtnLst = new ArrayList<List<Integer>>();
		int num = 1;
		int h = 0;
		if (root == null) {
			return rtnLst;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> lst = new ArrayList<Integer>();
			int numOnSameLevel = 0;
			for (int i = 0; i < num; i++) {
				TreeNode treeNode = queue.poll();
				if (h == 0) {
					lst.add(treeNode.val);
				} else {
					lst.add(0, treeNode.val);
				}
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					numOnSameLevel++;
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
					numOnSameLevel++;
				}
			}
			h = (h + 1) % 2;
			num = numOnSameLevel;
			rtnLst.add(lst);
		}
		return rtnLst;
	}
}
