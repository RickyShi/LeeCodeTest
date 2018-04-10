package repo_2014.binaryTreeTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * recursive
 * 
 * @author Ricky
 * 
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		return generateTree(root,list);
        }

	private List<Integer> generateTree(TreeNode root, List<Integer> list) {
		if (root == null) {
			return list;
		}
		generateTree(root.left, list);
		list.add(root.val);
		generateTree(root.right, list);

		return list;
	}
}
