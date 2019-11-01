package repo_2019_2020.first400.array;

public class q53_Maximum_Subarray {
    /**
     * Approach 2: Greedy
     * Intuition
     * <p>
     * The problem to find maximum (or minimum) element (or sum) with a single array
     * as the input is a good candidate to be solved by the greedy approach in linear time.
     * The algorithm is general and straightforward: iterate over the array and update at each step the standard set for such problems:
     * <p>
     * current element
     * <p>
     * current local maximum sum (at this given point)
     * <p>
     * global maximum sum seen so far.
     */
    public int maxSubArraGreedyF(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * Approach 3: Dynamic Programming (Kadane's algorithm)
     * Intuition
     * <p>
     * The problem to find sum or maximum or minimum in an entire array or in a fixed-size sliding window could be solved by the dynamic programming (DP) approach in linear time.
     * <p>
     * There are two standard DP approaches suitable for arrays:
     * <p>
     * Constant space one. Move along the array and modify the array itself.
     * <p>
     * Linear space one. First move in the direction left->right, then in the direction right->left. Combine the results. Q239 is an example.
     * <p>
     * Let's use here the first approach since one could modify the array to track the current local maximum sum at this given point.
     * <p>
     * Next step is to update the global maximum sum, knowing the local one.
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    /**
     * Approach 1: Divide and Conquer
     * Intuition
     * <p>
     * The problem is a classical example of divide and conquer approach, and can be solved with the algorithm similar with the merge sort.
     * <p>
     * Algorithm
     * <p>
     * maxSubArray for array with n numbers:
     * <p>
     * If n == 1 : return this single element.
     * <p>
     * left_sum = maxSubArray for the left subarray, i.e. for the first n/2 numbers (middle element at index (left + right) / 2 always belongs to the left subarray).
     * <p>
     * right_sum = maxSubArray for the right subarray, i.e. for the last n/2 numbers.
     * <p>
     * cross_sum = maximum sum of the subarray containing elements from both left and right subarrays and hence crossing the middle element at index (left + right) / 2.
     * <p>
     * Merge the subproblems solutions, i.e. return max(left_sum, right_sum, cross_sum).
     */
    class Solution {
        public int crossSum(int[] nums, int left, int right, int p) {
            if (left == right) return nums[left];

            int leftSubsum = Integer.MIN_VALUE;
            int currSum = 0;
            for (int i = p; i > left - 1; --i) {
                currSum += nums[i];
                leftSubsum = Math.max(leftSubsum, currSum);
            }

            int rightSubsum = Integer.MIN_VALUE;
            currSum = 0;
            for (int i = p + 1; i < right + 1; ++i) {
                currSum += nums[i];
                rightSubsum = Math.max(rightSubsum, currSum);
            }

            return leftSubsum + rightSubsum;
        }

        public int helper(int[] nums, int left, int right) {
            if (left == right) return nums[left];

            int p = (left + right) / 2;

            int leftSum = helper(nums, left, p);
            int rightSum = helper(nums, p + 1, right);
            int crossSum = crossSum(nums, left, right, p);

            return Math.max(Math.max(leftSum, rightSum), crossSum);
        }

        public int maxSubArray(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
    }
}
