package repo_2018.trimABinarySearchTree_669;

import repo_2018.commonStructure.TreeNode;


/**     Complexity Analysis
        Time Complexity: O(N)O(N), where NN is the total number of nodes in the given tree. We visit each node at most once.
        Space Complexity: O(N)O(N). Even though we don't explicitly use any additional memory, the call stack of our recursion could be as large as the number of nodes in the worst case.*/


public class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public TreeNode trimBSTComplex(TreeNode root, int L, int R) {
        if (root==null){
            return null;
        }
        else if (root.val<L){
            root = trimBST(root.right, L, R);
        }
        else if (root.val>R) {
            root = trimBST(root.left, L, R);
        }
        else{
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }

        return root;
    }
}
