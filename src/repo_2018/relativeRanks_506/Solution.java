package repo_2018.relativeRanks_506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ;i < nums.length ; i++) map.put(nums[i], i);
        Arrays.sort(nums);
        String[] rtn = new String[nums.length];
        for(int i = 0;i<nums.length;i++){
            if(i==nums.length-1) rtn[map.get(nums[i])]="Gold Medal";
            else if(i==nums.length-2) rtn[map.get(nums[i])]="Silver Medal";
            else if(i==nums.length-3) rtn[map.get(nums[i])]="Bronze Medal";
            else rtn[map.get(nums[i])]=String.valueOf(nums.length-i);
        }
        return rtn;
    }
}
