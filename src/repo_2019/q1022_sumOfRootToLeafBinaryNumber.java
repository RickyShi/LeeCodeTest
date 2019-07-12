package repo_2019;

import commonStructure.TreeNode;

public class q1022_sumOfRootToLeafBinaryNumber {
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = (sum * 2) + root.val;
        if ((root.left == null) && (root.right == null))
            return sum;
        return sumRootToLeaf(root.left, sum) + sumRootToLeaf(root.right, sum);
    }
}
