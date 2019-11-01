package repo_2019_2020.first400.array;

import commonStructure.TreeNode;

import java.util.*;

public class q236_lowerstCommonAncestorofaBinaryTree {
    /**
     * The approach is pretty intuitive. Traverse the tree in a depth first manner.
     * The moment you encounter either of the nodes p or q, return some boolean flag.
     * The flag helps to determine if we found the required nodes in any of the paths.
     * The least common ancestor would then be the node for which both the subtree recursions return a True flag.
     * It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.
     */
    class Solution1 {

        private TreeNode ans = null;

        private boolean recursiveTreeToFindPorQ(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = recursiveTreeToFindPorQ(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = recursiveTreeToFindPorQ(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            recursiveTreeToFindPorQ(root, p, q);
            return ans;
        }
    }

    /**
     * Similar to solution 1, but less code.
     * 对于任意的一个节点来说，如果以它为根节点去找两个节点的最低公共父节点，
     * 首先需要的是找到它的左右子树中是否存在有要查找的两个节点中的一个。
     * 如果找到任意一个则返回，否则返回null。
     * 而在回溯的时候，对于这个最低公共子节点有一个特性，它必然左右子节点返回的值都不为空的，而其他节点则总会有一个为空。
     * 所以在回溯的时候，如果它们中间有一个非空则返回不空的那个，如果左右子树的节点都不空则返回当前节点。
     */
    public class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }
    }

    /**
     * BFS
     */
    public class Solution3 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p == null || q == null) return null;
            Map<TreeNode, TreeNode> map = buildMap(root, p, q);
            Set<TreeNode> set = new HashSet<>();

            while (!set.contains(p)) {
                set.add(p);
                p = map.get(p);
            }

            while (!set.contains(q)) {
                q = map.get(q);
            }

            return q;
        }

        private Map<TreeNode, TreeNode> buildMap(TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> map = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            map.put(root, null);
            while (!map.containsKey(p) || !map.containsKey(q)) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    map.put(node.right, node);
                }
            }
            return map;
        }
    }
}
