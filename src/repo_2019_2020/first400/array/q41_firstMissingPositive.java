package repo_2019_2020.first400.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 */
public class q41_firstMissingPositive {
    /**
     * Hash set Approach. add/search for hashset is O(1)
     * So Overall O(n), space O(n)
     */
    static int firstMissingPositive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i > 0) {
                set.add(i);
                max = Math.max(max, i);
            }
        }
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

    /**
     * 我们的思路是把1放在数组第一个位置nums[0]，2放在第二个位置nums[1]，即需要把nums[i]放在nums[nums[i] - 1]上，
     * 那么我们遍历整个数组，如果nums[i] != i + 1, 而nums[i]为整数且不大于n，另外nums[i]不等于nums[nums[i] - 1]的话，我们将两者位置调换，
     * 如果不满足上述条件直接跳过，
     * 最后我们再遍历一遍数组，如果对应位置上的数不正确则返回正确的数
     * O(n) O(1)
     */
     static int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                //swap nums[i] and nums[nums[i]-1]
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        firstMissingPositive2(nums);
        /*for (int i : nums) {
            System.out.print(i + "");
        }*/
    }
}
