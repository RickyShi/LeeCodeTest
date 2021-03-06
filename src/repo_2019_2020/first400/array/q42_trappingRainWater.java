package repo_2019_2020.first400.array;

public class q42_trappingRainWater {
    /**
     * [解题思路]
     * 核心思想是：对某个值A[i]来说，能trapped的最多的water取决于在i之前最高的值leftMostHeight[i]
     * 和在i右边的最高的值rightMostHeight[i]。（均不包含自身）。如果min(left,right) >
     * A[i]，那么在i这个位置上能trapped的water就是min(left,right) – A[i]。
     *
     * 对于任何一个坐标，检查其左右的最大坐标，然后相减就是容积。所以，
     * 1. 从左往右扫描一遍，对于每一个坐标，求取左边最大值。
     * 2. 从右往左扫描一遍，对于每一个坐标，求最大右值。
     * 3. 再扫描一遍，求取容积并加和。
     * #2和#3可以合并成一个循环，
     */
    public static int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int[] leftMax = new int[A.length];
        int rtn = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            leftMax[i] = max;
            max = A[i] > max ? A[i] : max;

        }
        int rightMax = A[A.length - 1];
        for (int i = A.length - 2; i > 0; i--) {
            int tempTrap = Math.min(leftMax[i], rightMax) - A[i];
            rightMax = rightMax > A[i] ? rightMax : A[i];
            if (tempTrap > 0) {
                rtn += tempTrap;
            }
        }
        return rtn;
    }

    /**
     * more normal/clear way, use more memory. in C++
     *
     * int trap(vector<int>& height)
     * {
     * 	if(height == null)
     * 		return 0;
     *     int ans = 0;
     *     int size = height.size();
     *     vector<int> left_max(size), right_max(size);
     *     left_max[0] = height[0];
     *     for (int i = 1; i < size; i++) {
     *         left_max[i] = max(height[i], left_max[i - 1]);
     *     }
     *     right_max[size - 1] = height[size - 1];
     *     for (int i = size - 2; i >= 0; i--) {
     *         right_max[i] = max(height[i], right_max[i + 1]);
     *     }
     *     for (int i = 1; i < size - 1; i++) {
     *         ans += min(left_max[i], right_max[i]) - height[i];
     *     }
     *     return ans;
     * }
     */

    /**
     * Approach 3: Using stacks
     * Intuition
     *
     * Instead of storing the largest bar upto an index as in Approach 2, we can use stack to keep track of the bars that are bounded by longer bars and hence, may store water. Using the stack, we can do the calculations in only one iteration.
     *
     * We keep a stack and iterate over the array. We add the index of the bar to the stack if bar is smaller than or equal to the bar at top of stack, which means that the current bar is bounded by the previous bar in the stack. If we found a bar longer than that at the top, we are sure that the bar at the top of the stack is bounded by the current bar and a previous bar in the stack, hence, we can pop it and add resulting trapped water to \text{ans}ans.
     *
     * Algorithm
     *
     * Use stack to store the indices of the bars.
     * Iterate the array:
     * While stack is not empty and \text{height}[current]>\text{height}[st.top()]height[current]>height[st.top()]
     * It means that the stack element can be popped. Pop the top element as \text{top}top.
     * Find the distance between the current element and the element at top of stack, which is to be filled. \text{distance} = \text{current} - \text{st.top}() - 1distance=current−st.top()−1
     * Find the bounded height \text{bounded\_height} = \min(\text{height[current]}, \text{height[st.top()]}) - \text{height[top]}bounded_height=min(height[current],height[st.top()])−height[top]
     * Add resulting trapped water to answer \text{ans} \mathrel{+}= \text{distance} \times \text{bounded\_height}ans+=distance×bounded_height
     * Push current index to top of the stack
     * Move \text{current}current to the next position
     *
     * Code:
     * int trap(vector<int>& height)
     * {
     *     int ans = 0, current = 0;
     *     stack<int> st;
     *     while (current < height.size()) {
     *         while (!st.empty() && height[current] > height[st.top()]) {
     *             int top = st.top();
     *             st.pop();
     *             if (st.empty())
     *                 break;
     *             int distance = current - st.top() - 1;
     *             int bounded_height = min(height[current], height[st.top()]) - height[top];
     *             ans += distance * bounded_height;
     *         }
     *         st.push(current++);
     *     }
     *     return ans;
     * }
     */

    /**
     * Approach 4: Using 2 pointers
     * Intuition
     *
     * As in Approach 2, instead of computing the left and right parts seperately, we may think of some way to do it in one iteration. From the figure in dynamic programming approach, notice that as long as \text{right\_max}[i]>\text{left\_max}[i]right_max[i]>left_max[i] (from element 0 to 6), the water trapped depends upon the left_max, and similar is the case when \text{left\_max}[i]>\text{right\_max}[i]left_max[i]>right_max[i] (from element 8 to 11). So, we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar in current direction (from left to right). As soon as we find the bar at other end (right) is smaller, we start iterating in opposite direction (from right to left). We must maintain \text{left\_max}left_max and \text{right\_max}right_max during the iteration, but now we can do it in one iteration using 2 pointers, switching between the two.
     *
     * Algorithm
     *
     * Initialize \text{left}left pointer to 0 and \text{right}right pointer to size-1
     * While \text{left}< \text{right}left<right, do:
     * If \text{height[left]}height[left] is smaller than \text{height[right]}height[right]
     * If \text{height[left]} \geq \text{left\_max}height[left]≥left_max, update \text{left\_max}left_max
     * Else add \text{left\_max}-\text{height[left]}left_max−height[left] to \text{ans}ans
     * Add 1 to \text{left}left.
     * Else
     * If \text{height[right]} \geq \text{right\_max}height[right]≥right_max, update \text{right\_max}right_max
     * Else add \text{right\_max}-\text{height[right]}right_max−height[right] to \text{ans}ans
     * Subtract 1 from \text{right}right.
     *
     * int trap(vector<int>& height)
     * {
     *     int left = 0, right = height.size() - 1;
     *     int ans = 0;
     *     int left_max = 0, right_max = 0;
     *     while (left < right) {
     *         if (height[left] < height[right]) {
     *             height[left] >= left_max ? (left_max = height[left]) : ans += (left_max - height[left]);
     *             ++left;
     *         }
     *         else {
     *             height[right] >= right_max ? (right_max = height[right]) : ans += (right_max - height[right]);
     *             --right;
     *         }
     *     }
     *     return ans;
     * }
     */
}
