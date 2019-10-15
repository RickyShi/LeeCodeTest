package repo_2019_2020.first400.array;

public class q189_rotate_array {
    /**
     * Approach #1 Brute Force [Time Limit Exceeded]
     * The simplest approach is to rotate all the elements of the array in k steps by rotating the elements by 1 unit in each step.
     * T: O(n*k) S:O(1)
     */
    public void rotate(int[] nums, int k) {
        int temp, prev;
        if (nums == null || nums.length == 0) return;
        for (int i = 0; i < k; i++) {
            prev = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

    /**
     * Approach #2 Using Extra Array [Accepted]
     * We use an extra array in which we place every element of the array at its correct position
     * i.e. the number at index ii in the original array is placed at the index (i+k)%(length of array)(i+k). Then, we copy the new array to the original one.
     * T: O(n) S:O(n)
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * Need to be revisited
     * Approach #3 Using Cyclic Replacements [Accepted]
     * Assume k = k % n.
     * <p>
     * Imagine we have an array A = [0, 1, 2, 3, 4, 5, 6] (n = 7) and need to shift it right by k = 3 by HAND.
     * <p>
     * What I would do is start from index 0, hold A[0]=0 in hand, go to next index (0 + k) % n = (0 + 3) % 7 = 3, and swap A[3] with what I hold in hand, repeat this step until all elements are moved. The indexes of elements traversed form a closed chain 0 -> 3 -> 6 -> 2 -> 5 -> 1 -> 4 -> 0, which has 7 elements, equal to array length.
     * <p>
     * However, if n and k are not mutually prime, we may return to start position before moving all elements, forming a closed chain with elements fewer than n, e.g. n = 6, k = 4 => 0 -> 4 -> 2 -> 0, this chain only has L1 = 3 elements. To move all elements, we need to start from index 1 and traverse another chain 1 -> 5 -> 3 -> 1, which contains L2 = 3 different elements. In total we moved L1 + L2 = 3 + 3 = 6 == n elements, and each element moved only once.
     * <p>
     * The general procedures are:
     * <p>
     * start from index start = 0 (actually can be any other index)
     * cyclically shift element at index (start + m * k) right by k until reaching start again, forming a closed chain
     * shift start by 1, repeat step 1 and 2 until all elements moved.
     * <p>
     * https://leetcode.com/problems/rotate-array/discuss/259418/Clear-cyclic-replacement-Java-solution-with-proof
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        int count = 0; // check whether go all the items are replaced
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }

    /**
     * Approach #4 Using Reverse [Accepted]
     * Algorithm
     *
     * This approach is based on the fact that when we rotate the array k times, k%nk elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.
     *
     * In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n-kn−k elements gives us the required result.
     *
     * Let n=7 and k=3.
     *
     * Original List                   : 1 2 3 4 5 6 7
     * After reversing all numbers     : 7 6 5 4 3 2 1
     * After reversing first k numbers : 5 6 7 4 3 2 1
     * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start<=end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

}