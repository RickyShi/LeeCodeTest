package repo_2018.maxConsecutivesOnes_485;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int rtn = 0 ;
        int count = 0;
        for(int i:nums){
            if (i==1){
                count++;
                rtn = (rtn>count)?rtn:count;
            }else{
                count = 0;
            }
        }
        return rtn;
    }
}
