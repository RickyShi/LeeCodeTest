package repo_2018.diameterOfBinary_543;

import commonStructure.TreeNode;

/**
 * Approach #1: Depth-First Search [Accepted]
 * Intuition
 * <p>
 * Any path can be written as two arrows (in different directions) from some node, where an arrow is a path that starts at some node and only travels down to child nodes.
 * <p>
 * If we knew the maximum length arrows L, R for each child, then the best path touches L + R + 1 nodes.
 * <p>
 * Algorithm
 * <p>
 * Let's calculate the depth of a node in the usual way: max(depth of node.left, depth of node.right) + 1. While we do, a path "through" this node uses 1 + (depth of node.left) + (depth of node.right) nodes. Let's search each node and remember the highest number of nodes used in some path. The desired length is 1 minus this number.
 */
class Solution {
    int ans;

    //ans first server how many nodes are traversed
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    //maximum nodes
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
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
        t2.right = t5;
        TreeNode t6 = new TreeNode(6);


        Solution solution = new Solution();
        System.out.println(solution.depth(t1));
        System.out.println(solution.depth(t2));
        System.out.println(solution.depth(t5));
        System.out.println(solution.depth(t6));
    }
}

class SolutionRicky {
    int ans;

    //ans first server how many nodes are traversed
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans ;
    }

    //maximum nodes. L+R serve as how many length it go through
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R );
        return Math.max(L, R) + 1;
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
        t2.right = t5;
        TreeNode t6 = new TreeNode(6);


        Solution solution = new Solution();
        System.out.println(solution.depth(t1));
        System.out.println(solution.depth(t2));
        System.out.println(solution.depth(t5));
        System.out.println(solution.depth(t6));
    }
}
