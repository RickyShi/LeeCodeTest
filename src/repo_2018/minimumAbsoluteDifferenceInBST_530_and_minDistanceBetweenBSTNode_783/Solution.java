package repo_2018.minimumAbsoluteDifferenceInBST_530_and_minDistanceBetweenBSTNode_783;

import commonStructure.TreeNode;

import java.util.TreeSet;

public class Solution {
    public int getMinimumDifferenceRicky(TreeNode root) {
        int rtn = Integer.MAX_VALUE;
        if (root != null) {
            if (root.left != null) rtn = Math.min(rtn, root.val - findMostRight(root.left));
            if (root.right != null) rtn = Math.min(rtn, findMostLeft(root.right) - root.val);
            rtn = Math.min(rtn, Math.min(getMinimumDifferenceRicky(root.left), getMinimumDifferenceRicky(root.right)));
        }
        return rtn;
    }

    public int findMostRight(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public int findMostLeft(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    /** InOrder */
    public class SolutionInOrder {
        int min = Integer.MAX_VALUE;
        Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return min;

            getMinimumDifference(root.left);

            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }
            prev = root.val;

            getMinimumDifference(root.right);

            return min;
        }
    }

    /**
     * What if it is not a BST? (Follow up of the problem) The idea is to put values in a TreeSet and then every time we can use O(lgN) time to lookup for the nearest values.
     * <p>
     * Solution 2 - Pre-Order traverse, time complexity O(NlgN), space complexity O(N).
     */
    public class SolutionTreeSet {
        TreeSet<Integer> set = new TreeSet<>();
        int min = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return min;

            if (!set.isEmpty()) {
                if (set.floor(root.val) != null) {
                    min = Math.min(min, root.val - set.floor(root.val));
                }
                if (set.ceiling(root.val) != null) {
                    min = Math.min(min, set.ceiling(root.val) - root.val);
                }
            }

            set.add(root.val);

            getMinimumDifference(root.left);
            getMinimumDifference(root.right);

            return min;
        }
    }
}


