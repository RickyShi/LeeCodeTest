package repo_2018.nextGreaterElement1_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * <p>
 * Note:
 * <p>
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * 这道题给了我们一个数组，又给了该数组的一个子集合，让我们求集合中每个数字在原数组中右边第一个较大的数字。
 */
public class Solution {
    /**
     * Best Method linear time complexity O(n). Using hashMap and stack
     * Key observation:
    Suppose we have a decreasing sequence followed by a greater number
    For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

    We use a stack to keep a decreasing sub-sequence, whenever we see a number x greater than stack.peek() we pop all elements less than x and for all the popped ones, their next greater element is x
    For example [9, 8, 7, 3, 2, 1, 6]
    The stack will first contain [9, 8, 7, 3, 2, 1] and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6
     */
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }

    /**
     * Approach 2: bruce force O(n*m)
     * Don't forget to check last element, boundary case
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int p = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    p = j;
                    break;
                }
            }
            if (p == nums2.length - 1) nums1[i] = -1;
            for (int j = p + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
                if (j == nums2.length - 1 && nums1[i] >= nums2[j]) {
                    nums1[i] = -1;
                }
            }
        }
        return nums1;
    }

    /**
     * Approach 3:  O(n*m)
     * use hash map to locate the element faster
     */
    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int p ;
        for (int i = 0; i < nums1.length; i++) {
            p = map.get(nums1[i]);

            if (p == nums2.length - 1) nums1[i] = -1;
            for (int j = p + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    nums1[i] = nums2[j];
                    break;
                }
                if (j == nums2.length - 1 && nums1[i] >= nums2[j]) {
                    nums1[i] = -1;
                }
            }
        }
        return nums1;
    }
}
