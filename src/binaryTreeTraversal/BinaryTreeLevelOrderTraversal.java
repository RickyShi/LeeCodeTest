package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> rtnLst = new ArrayList<List<Integer>>();
		int num = 1;
		if (root == null) {
			return rtnLst;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> lst = new ArrayList<Integer>();
			int numOnSameLevel = 0;
			for (int i = 0; i < num; i++) {
				TreeNode treeNode = queue.poll();
				lst.add(treeNode.val);
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					numOnSameLevel++;
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
					numOnSameLevel++;
				}
			}
			num = numOnSameLevel;
			rtnLst.add(lst);
		}
		return rtnLst;
	}
}
