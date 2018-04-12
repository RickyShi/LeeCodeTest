package repo_2018.averageLevelsBinaryTree_637;

import repo_2018.commonStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /**
     * Approach #2 Breadth First Search [Accepted]
     * Algorithm
     * <p>
     * Another method to solve the given problem is to make use of a Breadth First Search. In BFS, we start by pushing the root node into a queue. Then, we remove an element(node) from the front of the queuequeue. For every node removed from the queuequeue, we add all its children to the back of the same queuequeue. We keep on continuing this process till the queue becomes empty. In this way, we can traverse the given tree on a level-by-level basis.
     * <p>
     * But, in the current implementation, we need to do a slight modification, since we need to separate the nodes on one level from that of the other.
     * <p>
     * The steps to be performed are listed below:
     * <p>
     * Put the root node into the queue.
     * <p>
     * Initialize sumsum and count as 0 and temp as an empty queue.
     * <p>
     * Pop a node from the front of the queuequeue. Add this node's value to the sumsum corresponding to the current level. Also, update the countcount corresponding to the current level.
     * <p>
     * Put the children nodes of the node last popped into the a temp queue(instead of queue).
     * <p>
     * Continue steps 3 and 4 till queue becomes empty. (An empty queue indicates that one level of the tree has been considered).
     * <p>
     * Reinitialize queue with its value as temp.
     * <p>
     * Populate the res array with the average corresponding to the current level.
     * <p>
     * Repeat steps 2 to 7 till the queue and temp become empty.
     * <p>
     * At the end, res is the required result.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n)O(n). The whole tree is traversed at most once. Here, nn refers to the number of nodes in the given binary tree.
     * <p>
     * Space complexity : O(m)O(m). The size of queue or temp can grow upto atmost the maximum number of nodes at any level in the given binary tree. Here, mm refers to the maximum number of nodes at any level in the input tree.
     */
    public List<Double> averageOfLevelsBFS(TreeNode root) {
        List<Double> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return null;
        q.offer(root);
        while (!q.isEmpty()) {
            double sum = 0;
            int count = 0;
            Queue<TreeNode> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode t = q.poll();
                sum += t.val;
                count++;
                if (t.left != null) {
                    temp.offer(t.left);
                }
                if (t.right != null) {
                    temp.offer(t.right);
                }
            }
            ls.add(sum / count);
            q = temp;
        }
        return ls;
    }

    /**
     * Actually No need to use another temp queue. calculate the size first for each level.
     */
    public List<Double> averageOfLevelsBFS2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        double sum = 0;
        while (!q.isEmpty()) {
//          calculate the size
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            result.add(sum / size);
            sum = 0;
        }

        return result;
    }

    /**
     * Algorithm
     * <p>
     * One of the methods to solve the given problem is to make use of Depth First Search. In DFS, we try to exhaust each branch of the given tree during the tree traversal before moving onto the next branch.
     * <p>
     * To make use of DFS to solve the given problem, we make use of two lists countcount and resres. Here, count[i]count[i] refers to the total number of nodes found at the i^{th}i
     * ​th
     * ​​  level(counting from root at level 0) till now, and res[i]res[i] refers to the sum of the nodes at the i^{th}i
     * ​th
     * ​​  level encountered till now during the Depth First Search.
     * <p>
     * We make use of a function average(t, i, res, count), which is used to fill the resres and countcount array if we start the DFS from the node tt at the i^{th}i
     * ​th
     * ​​  level in the given tree. We start by making the function call average(root, 0, res, count). After this, we do the following at every step:
     * <p>
     * Add the value of the current node to the resres(or sumsum) at the index corresponding to the current level. Also, increment the countcount at the index corresponding to the current level.
     * <p>
     * Call the same function, average, with the left and the right child of the current node. Also, update the current level used in making the function call.
     * <p>
     * Repeat the above steps till all the nodes in the given tree have been considered once.
     * <p>
     * Populate the averages in the resultant array to be returned.
     * Complexity Analysis
     * <p>
     * Time complexity : O(n)O(n). The whole tree is traversed once only. Here, nn refers to the total number of nodes in the given binary tree.
     * <p>
     * Space complexity : O(h)O(h). resres and countcount array of size hh are used. Here, hh refers to the height(maximum number of levels) of the given binary tree. Further, the depth of the recursive tree could go upto hh only.
     */
    public List<Double> averageOfLevelsDFS(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        average(root, res, 0, count);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }

    public void average(TreeNode root, List<Double> sum, int i, List<Integer> count) {
        if (root == null) return;
        if (i < sum.size()) {
            sum.set(i, root.val + sum.get(i));
            count.set(i, 1 + count.get(i));
        } else {
            sum.add(root.val * 1.0);
            count.add(1);
        }
        i++;
        average(root.left, sum, i, count);
        average(root.right, sum, i, count);


    }
}
