package repo_2018.minmumMovesToEqualArrayElements2_462;


import java.util.Arrays;

public class Solution {
    /**
     * Find the median
     This solution relies on the fact that if we increment/decrement each element to the median of all the elements, the optimal number of moves is necessary. The median of all elements can be found in expected O(n) time using QuickSelect (or deterministic O(n) time using Median of Medians).
     */
    public class SolutionMedian{
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int count = 0;
            for (int i : nums) {
                count += Math.abs(i - nums[nums.length / 2]);
            }
            return count;
        }
    }

    /** Only make sure the target value locates between the middle two level, so it is similar to median concept, yet it is much faster*/
    public class SolutionBestMeetingLocation{
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int count = 0,i =0,j=nums.length-1;
            while(i<j){
                count+=nums[j]-nums[i];
                i++;
                j--;
            }
            return count;
        }

    }
}
