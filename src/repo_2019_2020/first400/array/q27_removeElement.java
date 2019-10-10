package repo_2019_2020.first400.array;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * <p>
 * Algorithm
 * <p>
 * When nums[j]nums[j] equals to the given value, skip this element by incrementing jj. As long as nums[j] \neq valnums[j]
 * 
 * ​
 * =val, we copy nums[j]nums[j] to nums[i]nums[i] and increment both indexes at the same time. Repeat the process until jj reaches the end of the array and the new length is ii.
 */
public class q27_removeElement {
    public int removeElement(int[] nums, int val) {
        int j = 0; //slow runner
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums [i];
                j++;
            }
        }
        return j;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
