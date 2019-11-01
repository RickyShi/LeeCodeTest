package repo_2019_2020.first400.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * sort the array first
 * do fix 1st element and set two pointers low and high
 * move to the middle
 */
public class q15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rtn = new ArrayList<>();
        if (nums == null || nums.length < 3) return rtn;

        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == 0) {
                    rtn.add(new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high])));
                }

                if (sum < 0) {
                    while (low + 1 < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                }

                if (sum > 0) {
                    while (low < high - 1 && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    high--;
                }

            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return rtn;
    }
}
