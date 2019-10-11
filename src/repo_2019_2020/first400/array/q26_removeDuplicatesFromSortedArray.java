package repo_2019_2020.first400.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class q26_removeDuplicatesFromSortedArray {
    /**
     * Algorithm
     * <p>
     * Since the array is already sorted, we can keep two pointers ii and jj, where ii is the slow-runner while jj is the fast-runner. As long as nums[i] = nums[j]nums[i]=nums[j], we increment jj to skip the duplicate.
     * <p>
     * When we encounter nums[j] \neq nums[i]nums[j]
     * =nums[i], the duplicate run has ended so we must copy its value to nums[i + 1]nums[i+1]. ii is then incremented and we repeat the same process again until jj reaches the end of array.
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums==null|| nums.length== 0) return 0;
        int i = 0; //slow runner
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
