package repo_2018.convertBSTToGreaterTree_538;

import repo_2018.commonStructure.TreeNode;

import java.util.Stack;

public class Solution {
    /**
     * Initial Thoughts
     * This question asks us to modify an asymptotically linear number of nodes in a given binary search tree, so a very efficient solution will visit each node once.
     * The key to such a solution would be a way to visit nodes in descending order, keeping a sum of all values that we have already visited and adding that sum to the node's values as we traverse the tree.
     * This method for tree traversal is known as a reverse in-order traversal, and allows us to guarantee visitation of each node in the desired order.
     * The basic idea of such a traversal is that before visiting any node in the tree, we must first visit all nodes with greater value. Where are all of these nodes conveniently located? In the right subtree.
     */

    /**
     * Approach #1 Recursion [Accepted]
     * Intuition
     * <p>
     * One way to perform a reverse in-order traversal is via recursion. By using the call stack to return to previous nodes, we can easily visit the nodes in reverse order.
     * <p>
     * Algorithm
     * <p>
     * For the recursive approach, we maintain some minor "global" state so each recursive call can access and modify the current total sum. Essentially, we ensure that the current node exists, recurse on the right subtree, visit the current node by updating its value and the total sum, and finally recurse on the left subtree. If we know that recursing on root.right properly updates the right subtree and that recursing on root.left properly updates the left subtree, then we are guaranteed to update all nodes with larger values before the current node and all nodes with smaller values after.
     */
    class Recursive {
        int sum = 0;

        /**
         * descending order add sum and traverse
         */
        public TreeNode convertBST(TreeNode root) {
            if (root == null) return null;
            convertBST(root.right);
            sum += root.val;
            //Don't forget to assign the sum back to val;
            root.val = sum;
            convertBST(root.left);
            return root;
        }
    }

    /**
     * Approach #2 Iteration with a Stack [Accepted]
     * Intuition
     *
     * If we don't want to use recursion, we can also perform a reverse in-order traversal via iteration and a literal stack to emulate the call stack.
     *
     * Algorithm
     *
     * One way to describe the iterative stack method is in terms of the intuitive recursive solution. First, we initialize an empty stack and set the current node to the root. Then, so long as there are unvisited nodes in the stack or node does not point to null, we push all of the nodes along the path to the rightmost leaf onto the stack. This is equivalent to always processing the right subtree first in the recursive solution, and is crucial for the guarantee of visiting nodes in order of decreasing value. Next, we visit the node on the top of our stack, and consider its left subtree. This is just like visiting the current node before recursing on the left subtree in the recursive solution. Eventually, our stack is empty and node points to the left null child of the tree's minimum value node, so the loop terminates.
     */
    class iterative{
        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode node = root;
            Stack<TreeNode> stack = new Stack<TreeNode>();

            while (!stack.isEmpty() || node != null) {
                /* push all nodes up to (and including) this subtree's maximum on
                 * the stack. */
                while (node != null) {
                    stack.add(node);
                    node = node.right;
                }

                node = stack.pop();
                sum += node.val;
                node.val = sum;

                /* all nodes with values between the current and its parent lie in
                 * the left subtree. */
                node = node.left;
            }

            return root;
        }
    }
}
