package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Not using num to store as BFS_1; Using queue.size();
 * 
 * Using Add(index,object) method to reverse the result
 * 
 * @author Ricky
 * 
 */
public class BinaryTreeLevelOrderTraversalBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> rtnLst = new ArrayList<List<Integer>>();
		// int num = 1;
		if (root == null) {
			return rtnLst;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> lst = new ArrayList<Integer>();
			// int numOnSameLevel = 0;
			while (size > 0) {
				TreeNode treeNode = queue.poll();
				lst.add(treeNode.val);
				if (treeNode.left != null) {
					queue.offer(treeNode.left);
					// numOnSameLevel++;
				}
				if (treeNode.right != null) {
					queue.offer(treeNode.right);
					// numOnSameLevel++;
				}
				size--;
			}
			// num = numOnSameLevel;
			rtnLst.add(0, lst);
		}
		return rtnLst;
	}
}
