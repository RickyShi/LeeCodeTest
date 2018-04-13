package repo_2018.maxDepthBinaryTree_104;

import repo_2018.commonStructure.TreeNode;

import java.util.Stack;

public class Solution {
    public int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    /**Iterative way, just for fun*/
    public int maxDepth(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();

        int max = 0;
        int depth = 1;
        while (node != null || !nodeStack.isEmpty()) {
            if (node != null) {
                nodeStack.push(node);
                depthStack.push(depth);
                node = node.left;
                depth++;
            } else {
                node = nodeStack.pop();
                depth = depthStack.pop();

                if (depth > max) max = depth;

                node = node.right;
                depth++;
            }
        }

        return max;
    }
}
