package repo_2018.twoSum1_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int searchKey = target-nums[i];
            if(map.containsKey(searchKey)){
                return new int[]{map.get(searchKey),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Two Sum Result");
    }
}
