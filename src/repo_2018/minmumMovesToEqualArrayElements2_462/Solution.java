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

        /**
         * find the median using quick select Avg O(n) See Reference 215
         */
        public int minMoves2QuickSelect(int[] nums) {

            int sum = 0, median = selectRecursive(nums, nums.length/2+1);
            for (int num : nums) sum += Math.abs(num - median);
            return sum;
        }

        public  int selectRecursive(int[] array, int n) {
            return recursive(array, 0, array.length - 1, n);
        }

        // Returns the n-th smallest element of list within left..right inclusive
        // (i.e. left <= n <= right).
        // The size of the list is not changing with each recursion.
        // Thus, n does not need to be updated with each round.
        private  int recursive(int[] array, int left, int right, int n) {
            if (left == right) { // If the list contains only one element,
                return array[left]; // return that element
            }

            // select a pivotIndex between left and right
            int pivotIndex = (right-left)/2;
            pivotIndex = partition(array, left, right, pivotIndex);
            // The pivot is in its final sorted position
            if (n == pivotIndex) {
                return array[n];
            } else if (n < pivotIndex) {
                return recursive(array, left, pivotIndex - 1, n);
            } else {
                return recursive(array, pivotIndex + 1, right, n);
            }
        }

        /**
         * In quicksort, there is a subprocedure called partition that can, in
         * linear time, group a list (ranging from indices left to right) into two
         * parts, those less than a certain element, and those greater than or
         * equal to the element. Here is pseudocode that performs a partition about
         * the element list[pivotIndex]
         */
        private  int partition(int[] array, int left, int right, int pivotIndex) {
            int pivotValue = array[pivotIndex];
            swap(array, pivotIndex, right); // move pivot to end
            int storeIndex = left;
            for (int i = left; i < right; i++) {
                if (array[i] < pivotValue) {
                    swap(array, storeIndex, i);
                    storeIndex++;
                }
            }
            swap(array, right, storeIndex); // Move pivot to its final place
            return storeIndex;
        }

        private  void swap(int[] array, int a, int b) {
            int tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
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
