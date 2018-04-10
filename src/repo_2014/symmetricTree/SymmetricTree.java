package repo_2014.symmetricTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric
 * around its center).
 *
 * For example, this binary tree is symmetric:
 *
 * 1
 * / \
 * 2 2
 * / \ / \
 * 3 4 4 3
 *
 * @author Ricky
 *
 */
public class SymmetricTree {
	/**
	 * put left sub tree to l List
	 * put right sub tree to r List
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> l = new LinkedList<TreeNode>(), r = new LinkedList<TreeNode>();
		l.offer(root.left);
		r.offer(root.right);
		while (!l.isEmpty() && !r.isEmpty()) {
			TreeNode temp1 = l.poll(), temp2 = r.poll();
			if (temp1 == null && temp2 != null || temp1 != null && temp2 == null) {
				return false;
			}
			if (temp1 != null) {
				if (temp1.val != temp2.val) {
					return false;
				}
				l.offer(temp1.left);
				l.offer(temp1.right);
				r.offer(temp2.right);
				r.offer(temp2.left);
			}
		}
		return true;
	}

	/**
	 *
	 * Input: {2,3,3,4,5,5,4,#,#,8,9,#,#,9,8}
	 * Output: true
	 * Expected: false
	 *
	 * Wrong Answer
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetricWrong(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return true;
		}
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int[] arr = new int[size];
			while (size > 0) {
				TreeNode n = queue.poll();
				arr[size - 1] = n.val;
				TreeNode nvl = new TreeNode(-1);
				if (n.left == null && n.right != null) {
					queue.offer(nvl);
					queue.offer(n.right);
				} else if (n.left != null && n.right == null) {
					queue.offer(n.left);
					queue.offer(nvl);
				} else {
					if (n.left != null) {
						queue.offer(n.left);
					}
					if (n.right != null) {
						queue.offer(n.right);
					}
				}
				size--;
			}
			int start = 0, end = arr.length - 1;
			while (start <= end) {
				if (arr[start] != arr[end]) {
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
	}
}


