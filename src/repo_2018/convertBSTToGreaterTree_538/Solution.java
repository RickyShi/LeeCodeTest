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
     * <p>
     * If we don't want to use recursion, we can also perform a reverse in-order traversal via iteration and a literal stack to emulate the call stack.
     * <p>
     * Algorithm
     * <p>
     * One way to describe the iterative stack method is in terms of the intuitive recursive solution. First, we initialize an empty stack and set the current node to the root. Then, so long as there are unvisited nodes in the stack or node does not point to null, we push all of the nodes along the path to the rightmost leaf onto the stack. This is equivalent to always processing the right subtree first in the recursive solution, and is crucial for the guarantee of visiting nodes in order of decreasing value. Next, we visit the node on the top of our stack, and consider its left subtree. This is just like visiting the current node before recursing on the left subtree in the recursive solution. Eventually, our stack is empty and node points to the left null child of the tree's minimum value node, so the loop terminates.
     */
    class iterative {
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

    /**
     * Approach #3 Reverse Morris In-order Traversal [Accepted] T: O(n) S:O(1)
     * Intuition
     * <p>
     * There is a clever way to perform an in-order traversal using only linear time and constant space, first described by J. H. Morris in his 1979 paper "Traversing Binary Trees Simply and Cheaply". In general, the recursive and iterative stack methods sacrifice linear space for the ability to return to a node after visiting its left subtree. The Morris traversal instead exploits the unused null pointer(s) of the tree's leaves to create a temporary link out of the left subtree, allowing the traversal to be performed using only constant additional memory. To apply it to this problem, we can simply swap all "left" and "right" references, which will reverse the traversal.
     * <p>
     * Algorithm
     * <p>
     * First, we initialize node, which points to the root. Then, until node points to null (specifically, the left null of the tree's minimum-value node), we repeat the following. First, consider whether the current node has a right subtree. If it does not have a right subtree, then there is no unvisited node with a greater value, so we can visit this node and move into the left subtree. If it does have a right subtree, then there is at least one unvisited node with a greater value, and thus we must visit first go to the right subtree. To do so, we obtain a reference to the in-order successor (the smallest-value node larger than the current) via our helper function getSuccessor. This successor node is the node that must be visited immediately before the current node, so it by definition has a null left pointer (otherwise it would not be the successor). Therefore, when we first find a node's successor, we temporarily link it (via its left pointer) to the node and proceed to the node's right subtree. Then, when we finish visiting the right subtree, the leftmost left pointer in it will be our temporary link that we can use to escape the subtree. After following this link, we have returned to the original node that we previously passed through, but did not visit. This time, when we find that the successor's left pointer loops back to the current node, we know that we have visited the entire right subtree, so we can now erase the temporary link and move into the left subtree.
     */
    class morrisTraverse {
        /* Get the node with the smallest value greater than this one. */
        private TreeNode getSuccessor(TreeNode node) {
            TreeNode succ = node.right;
            while (succ.left != null && succ.left != node) {
                succ = succ.left;
            }
            return succ;
        }

        public TreeNode convertBST(TreeNode root) {
            int sum = 0;
            TreeNode node = root;

            while (node != null) {
                /*
                 * If there is no right subtree, then we can visit this node and
                 * continue traversing left.
                 */
                if (node.right == null) {
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
                /*
                 * If there is a right subtree, then there is at least one node that
                 * has a greater value than the current one. therefore, we must
                 * traverse that subtree first.
                 */
                else {
                    TreeNode succ = getSuccessor(node);
                    /*
                     * If the left subtree is null, then we have never been here before.
                     */
                    if (succ.left == null) {
                        succ.left = node;
                        node = node.right;
                    }
                    /*
                     * If there is a left subtree, it is a link that we created on a
                     * previous pass, so we should unlink it and visit this node.
                     */
                    else {
                        succ.left = null;
                        sum += node.val;
                        node.val = sum;
                        node = node.left;
                    }
                }
            }

            return root;
        }
    }
}
