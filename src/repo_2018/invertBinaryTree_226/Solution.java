package repo_2018.invertBinaryTree_226;

import commonStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /** DFS */
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    /**BFs*/
    public TreeNode invertTree2(TreeNode root) {
        if (root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            TreeNode tmp = t.left;
            t.left = t.right;
            t.right = tmp;
            if(t.left!=null) q.offer(t.left);
            if(t.right!=null) q.offer(t.right);
        }
        return root;
    }
}
