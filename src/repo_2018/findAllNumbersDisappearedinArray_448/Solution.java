package repo_2018.findAllNumbersDisappearedinArray_448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(solution.findDisappearedNumbers(input));
    }

    /**
     * Ricky's way using hash set. extra storage is needed.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> rtn = new ArrayList<>();

        for(int i:nums){
            set.add(i);
        }

        for (int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                rtn.add(i);
            }
        }
        return rtn;
    }

    /**
     * no extra storage is needed. Smart one.
     */
    public List<Integer> findDisappearedNumbersNoExtraStorage(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
