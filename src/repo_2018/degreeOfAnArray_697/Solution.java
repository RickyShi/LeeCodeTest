package repo_2018.degreeOfAnArray_697;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (!left.containsKey(nums[i])) left.put(nums[i],i);
            else right.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        int rtn = nums.length;
        int degree = Collections.max(count.values());
        if (degree == 1) return 1;
        for(int k:count.keySet()){
            if(count.get(k)==degree){
                rtn = Math.min(rtn,right.get(k)-left.get(k)+1);
            }
        }
        return rtn;
    }
}
