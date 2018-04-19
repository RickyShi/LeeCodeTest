package repo_2018.moveZeros_283;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {0, 0, 1, 2, 0, 3, 4, 0, 0, 0, 5, 6, 0};
        for (int i : solution.moveZeroes(input)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : solution.moveZeroesSimple(input)) {
            System.out.print(i + " ");
        }
    }

    /**
     * Ricky's method. Using two pointers to move. Swap nums[i] and nums[j]
     * IF nums[j]==0 is seen, keep moving pointer j right.
     * j is faster pointer here.
     */
    public int[] moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length - 1 && j < nums.length) {
            if (nums[i] == 0) {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
            j++;
        }
        return nums;
    }

    /**
     * Still two pointers to move. Swap nums[i] and nums[j]. Using faster pointer to loop is much more simple and clear.
     * The previous, I'm using slower pointer to loop, thus I need two whiles and more complex.
     * i is faster pointer here.
     */
    public int[] moveZeroesSimple(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

    /**
     * Bring all the non 0 elements to the front of array keeping their relative order same
     * just set the current value to last Seen position, and set the rest element to be the zero. Yet more unnecessary action is taken.
     */
    public int[] moveZeroes2(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }
        for (int i = lastNonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
