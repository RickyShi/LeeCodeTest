package repo_2018.minmumMovesToEqualArrayElements_453;

import java.util.Arrays;

/**
 * Let's define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;
 * <p>
 * After, say m moves, we get all the numbers as x , and we will get the following equation
 * <p>
 * sum + m * (n - 1) = x * n
 * and actually,
 * <p>
 * x = minNum + m
 * and finally, we will get
 * <p>
 * sum - minNum * n = m
 * So, it is clear and easy now.
 */
public class Solution {

    public int minMovesRicky(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i:nums){
            sum+=i;
        }
        return sum-nums[0]*nums.length;
    }

    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }
}
