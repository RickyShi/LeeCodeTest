package repo_2018.twoSum5_653;

import commonStructure.TreeNode;

import java.util.*;

public class Solution {

    /**
     * Approach #1 Using HashSet[Accepted]
     * The simplest solution will be to traverse over the whole tree and consider every possible pair of nodes to determine if they can form the required sum kk. But, we can improve the process if we look at a little catch here.
     *
     * If the sum of two elements x + yx+y equals kk, and we already know that xx exists in the given tree, we only need to check if an element yy exists in the given tree, such that y = k - xy=k−x. Based on this simple catch, we can traverse the tree in both the directions(left child and right child) at every step. We keep a track of the elements which have been found so far during the tree traversal, by putting them into a setset.
     *
     * For every current node with a value of pp, we check if k-pk−p already exists in the array. If so, we can conclude that the sum kk can be formed by using the two elements from the given tree. Otherwise, we put this value pp into the setset.
     *
     * If even after the whole tree's traversal, no such element pp can be found, the sum kk can't be formed by using any two elements.
     */
    public class HashSetDFS {
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return isFound(root, k, set);
        }

        public boolean isFound(TreeNode root, int k, Set set) {
            if (root == null) return false;
            if (set.contains(k - root.val)) return true;
            set.add(root.val);
            return isFound(root.left, k, set) || isFound(root.right, k, set);
        }
    }

    /**
     * Approach #2 Using BFS and HashSet [Accepted]
     * Algorithm
     *
     * In this approach, the idea of using the setset is the same as in the last approach. But, we can carry on the traversal in a Breadth First Search manner, which is a very common traversal method used in Trees. The way BFS is used can be summarized as given below. We start by putting the root node into a queuequeue. We also maintain a setset similar to the last approach. Then, at every step, we do as follows:
     *
     * Remove an element, pp, from the front of the queuequeue.
     *
     * Check if the element k-pk−p already exists in the setset. If so, return True.
     *
     * Otherwise, add this element, pp to the setset. Further, add the right and the left child nodes of the current node to the back of the queuequeue.
     *
     * Continue steps 1. to 3. till the queuequeue becomes empty.
     *
     * Return false if the queuequeue becomes empty.
     *
     * By following this process, we traverse the tree on a level by level basis.
     */
    public class HashSetBFS {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            Set<Integer> set = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                if (set.contains(k - t.val)) return true;
                set.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            return false;
        }
    }

    /**
     * Approach #3 Using BST [Accepted]
     * Algorithm
     *
     * In this approach, we make use of the fact that the given tree is a Binary Search Tree. Now, we know that the inorder traversal of a BST gives the nodes in ascending order. Thus, we do the inorder traversal of the given tree and put the results in a listlist which contains the nodes sorted in ascending order.
     *
     * Once this is done, we make use of two pointers ll and rr pointing to the beginning and the end of the sorted listlist. Then, we do as follows:
     *
     * Check if the sum of the elements pointed by ll and rr is equal to the required sum kk. If so, return a True immediately.
     *
     * Otherwise, if the sum of the current two elements is lesser than the required sum kk, update ll to point to the next element. This is done, because, we need to increase the sum of the current elements, which can only be done by increasing the smaller number.
     *
     * Otherwise, if the sum of the current two elements is larger than the required sum kk, update rr to point to the previous element. This is done, because, we need to decrease the sum of the current elements, which can only be done by reducing the larger number.
     *
     * Continue steps 1. to 3. till the left pointer ll crosses the right pointer rr.
     *
     * If the two pointers cross each other, return a False value.
     */
    public class InOrderTraverse {
        public boolean findTarget(TreeNode root, int k) {
            List< Integer > list = new ArrayList();
            inorder(root, list);
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k)
                    return true;
                if (sum < k)
                    l++;
                else
                    r--;
            }
            return false;
        }
        public void inorder(TreeNode root, List < Integer > list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
