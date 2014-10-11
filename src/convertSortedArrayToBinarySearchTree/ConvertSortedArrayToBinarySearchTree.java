package convertSortedArrayToBinarySearchTree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 * 
 * @author Ricky
 * 
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return generateTree(num, 0, num.length - 1);
	}

	private TreeNode generateTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(array[start]);
		}
		int middle = (start + end) / 2;
		TreeNode root = new TreeNode(array[middle]);
		root.left = generateTree(array, start, middle - 1);
		root.right = generateTree(array, middle + 1, end);
		return root;
	}
}
