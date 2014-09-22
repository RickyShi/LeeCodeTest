package uniqueBinarySearchTree;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
	}
}
public class UniqueBinarySearchTrees2 {
	public List<TreeNode> generateTrees(int n) {
		return generateTree(1, n);
	}

	private List<TreeNode> generateTree(int start, int end) {
		List<TreeNode> treeNodes = new LinkedList<TreeNode>();

		if (start > end) {
			treeNodes.add(null);
			return treeNodes;
		}
		for (int i=start;i<=end;i++){
			List<TreeNode> lefts = generateTree(start, i - 1);
			List<TreeNode> rights = generateTree(i + 1, end - 1);
			TreeNode treeNode = new TreeNode(i);
			for (TreeNode right : rights) {
				for (TreeNode left : lefts) {
					treeNodes.add(left);
					treeNode.left = left;
					treeNode.right = right;
					treeNodes.add(treeNode);
				}
			}
		}
		return treeNodes;
	}
}
