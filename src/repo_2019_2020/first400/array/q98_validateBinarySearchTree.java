package repo_2019_2020.first400.array;

import commonStructure.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

public class q98_validateBinarySearchTree {
    /**
     * Approach 1: Recursion
     * The idea above could be implemented as a recursion.
     * One compares the node value with its upper and lower limits if they are available.
     * Then one repeats the same step recursively for left and right subtrees.
     */
    public class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, Integer low, Integer high) {
            if (root == null) return true;
            int val = root.val;
            if (low != null && val <= low) return false;
            if (high != null && val >= high) return false;

            if (!helper(root.left, low, val)) return false;
            if (!helper(root.right, val, high)) return false;

            return true;
        }
    }

    /**
     * Approach 2: Iteration
     * The above recursion could be converted into iteration, with the help of stack.
     * DFS would be better than BFS since it works faster here.
     */
    class Solution2 {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> uppers = new LinkedList<>(),
                lowers = new LinkedList<>();

        public void update(TreeNode root, Integer lower, Integer upper) {
            stack.add(root);
            lowers.add(lower);
            uppers.add(upper);
        }

        public boolean isValidBST(TreeNode root) {
            Integer lower = null, upper = null, val;
            update(root, lower, upper);

            while (!stack.isEmpty()) {
                root = stack.poll();
                lower = lowers.poll();
                upper = uppers.poll();

                if (root == null) continue;
                val = root.val;
                if (lower != null && val <= lower) return false;
                if (upper != null && val >= upper) return false;
                update(root.right, val, upper);
                update(root.left, lower, val);
            }
            return true;
        }
    }

    /**
     * Approach 3: Inorder traversal
     * Algorithm
     *
     * Let's use the order of nodes in the inorder traversal Left -> Node -> Right.
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            double inorder = - Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (root.val <= inorder) return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }
}
