package repo_2018.mergeTwoBinaryTrees_617;

import commonStructure.TreeNode;

import java.util.Stack;

public class Solutions {

}


/**
 * Definition for a binary tree node.
 */
/*  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }*/

class SolutionRecursive {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        /** Recursive Complexity Analysis
         Time complexity : O(m). A total of mm nodes need to be traversed. Here, mm represents the minimum number of nodes from the two given trees.
         Space complexity : O(m). The depth of the recursion tree can go upto mm in the case of a skewed tree. In average case, depth will be O(logm)O(logm).
         */
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}

class SolutionIterative {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        /** Iterative   Complexity Analysis
         Time complexity : O(n). We traverse over a total of nn nodes. Here, nn refers to the smaller of the number of nodes in the two trees.
         Space complexity : O(n). The depth of stack can grow upto nn in case of a skewed tree.
         */

        if (t1 == null)
            return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left != null) {
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            } else {
                t[0].left = t[1].left;
            }
            if (t[0].right != null) {
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            } else {
                t[0].right = t[1].right;
            }
        }
        return t1;
    }
}