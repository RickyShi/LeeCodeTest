package repo_2018.sameTree_100;

import commonStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;//p,q both null case is checked
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    /**
     * BFS
     */
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if (f == null && s == null) {
                continue;
            } else if (f == null || s == null || f.val != s.val) {
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }
        return true;
    }

    /**
     * DFS NON Recursive
     */
    public boolean isSameTreeDFSStack(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if (p != null) stack_p.push(p);
        if (q != null) stack_q.push(q);
        while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
            TreeNode pn = stack_p.pop();
            TreeNode qn = stack_q.pop();
            if (pn.val != qn.val) return false;
            if (pn.left != null) stack_p.push(pn.left);
            if (qn.left != null) stack_q.push(qn.left);
            if (stack_p.size() != stack_q.size()) return false;
            if (pn.right != null) stack_p.push(pn.right);
            if (qn.right != null) stack_q.push(qn.right);
            if (stack_p.size() != stack_q.size()) return false;
        }
        return stack_p.size() == stack_q.size();
    }
}
