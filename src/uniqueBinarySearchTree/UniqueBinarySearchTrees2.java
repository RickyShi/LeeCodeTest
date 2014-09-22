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
			List<TreeNode> rights = generateTree(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode treeNode = new TreeNode(i);
					treeNode.left = left;
					treeNode.right = right;
					treeNodes.add(treeNode);
				}
			}
		}
		return treeNodes;
	}
}
