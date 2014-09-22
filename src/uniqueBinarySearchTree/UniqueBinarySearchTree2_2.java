package uniqueBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree2_2 {
	public List<TreeNode> generateTrees(int n) {
		Object[][] container = new Object[n + 1][n + 1];
		return generateTrees2(1, n, container);
	}

	@SuppressWarnings("unchecked")
	public List<TreeNode> generateTrees2(int start, int end,
			Object[][] container) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		if (start > end) {
			nodes.add(null);
			return nodes;
		}
		if (container[start][end] != null) {
			return (List<TreeNode>) container[start][end];
		}
		if (start == end) {
			nodes.add(new TreeNode(start));
		} else {
			for (int i = start; i <= end; i++) {
				List<TreeNode> leftNodes = generateTrees2(start, i - 1,
						container);
				List<TreeNode> rightNodes = generateTrees2(i + 1, end,
						container);
				for (int m = 0; m < leftNodes.size(); m++) {
					for (int m1 = 0; m1 < rightNodes.size(); m1++) {
						TreeNode root = new TreeNode(i);
						root.left = leftNodes.get(m);
						root.right = rightNodes.get(m1);
						nodes.add(root);
					}
				}
			}
		}
		container[start][end] = nodes;
		return nodes;
	}
}
