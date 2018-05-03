package repo_2018.binaryTreeTilt_563;

import repo_2018.commonStructure.TreeNode;

public class Solution {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode root) {
        if (root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }

    /**
     * no global Ricky's Way
     */
    public int findTilt2(TreeNode root) {
        if (root == null) return 0;

        int currentTilt = Math.abs(findNodeSum(root.left) - findNodeSum(root.right));

        return currentTilt + findTilt2(root.left) + findTilt2(root.right);
    }

    public int findNodeSum(TreeNode root) {
        if (root == null) return 0;

        return root.val + findNodeSum(root.left) + findNodeSum(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        Solution solution = new Solution();

        long startTime = System.nanoTime();
        System.out.println(solution.findTilt(t1));
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        System.out.println(solution.findTilt2(t1));
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);



    }
}
