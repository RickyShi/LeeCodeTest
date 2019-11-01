package repo_2019_2020.first400.array;

import java.util.HashMap;
import java.util.Map;

public class q1_twoSum {
    /**
     * One-pass Hash Table
     * It turns out we can do it in one-pass.
     * While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table.
     * If it exists, we have found a solution and return immediately.
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
