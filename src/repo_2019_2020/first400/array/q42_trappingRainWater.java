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
}
