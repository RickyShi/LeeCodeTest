package repo_2014.populateNextRightPointersInEachNode;

public class PopulateNextRightPointersInEachNode1Rec {
	/**
	 * Recursive way
	 * reference: http://goo.gl/qo6rGk
	 */
	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		}

		connect(root.left);
		connect(root.right);
	}
}
