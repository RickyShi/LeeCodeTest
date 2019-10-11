package repo_2019_2020.first400.array;

public class q80_removeDuplicatesFromSortedArray2 {

    /**
     * Two Point Approach
     * newLength is slow-runner
     * i is fast-runner
     * @param nums
     * @param atMostParameter allow at most duplicated letters
     * @return
     */
    public int removeDuplicatesOverTime(int[] nums, int atMostParameter) {

        int prev = Integer.MAX_VALUE;
        int newLength = 0;
        int seenInARow = 1;


        for (int i = 0; i < nums.length; i++) {

            seenInARow = (nums[i] == prev) ? seenInARow + 1 : 1;

            if (seenInARow <= atMostParameter) {
                nums[newLength++] = nums[i];
                prev = nums[i];
            }
        }

        return newLength;
    }

    /**
     * Too complicated to updates all the elements in [slow runner, fast runner] after finding the different int at fast-runner location
     * recommend above simple method, just use another var prev to store the value (instead of nums[slow-runner]), much more simple
     * @param nums
     * @param atMostParameter allow at most duplicated letters
     * @return
     */
    public int removeDuplicatesOverTime2(int[] nums, int atMostParameter) {
        if (nums==null|| nums.length== 0) return 0;
        int i = 0; //slow runner
        int count = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                int t = i;
                while (t < j) {
                    nums[t] = nums[j];
                    t++;
                }
                count =  1;
            } else if (count <= atMostParameter - 1) {
                i++;
                count++;
            } else {
                count++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 5, 5, 6};
        int[] nums2 = nums.clone();
        q80_removeDuplicatesFromSortedArray2 test = new q80_removeDuplicatesFromSortedArray2();

        test.removeDuplicatesOverTime(nums, 2);

        /*for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("---------------------");


        System.out.println(test.removeDuplicatesOverTime2(nums, 2));
        System.out.println();
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println("---------------------");

        for (int i : nums2) {
            System.out.print(i + ", ");
        }

        System.out.println();
        System.out.println("---------------------");

        System.out.println(test.removeDuplicatesOverTime(nums2,2));
        System.out.println();
        for (int i : nums2) {
            System.out.print(i + ", ");
        }*/
    }
}
