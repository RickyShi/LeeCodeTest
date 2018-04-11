package repo_2018.arrayPartition1_561;

import java.util.Arrays;

/** make sure sort first and get the sum of the odd value*/
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int rtn = 0;
        for (int i = 0; i<nums.length;i=i+2){
            rtn = rtn + nums[i];
        }
        return rtn;
    }
}
