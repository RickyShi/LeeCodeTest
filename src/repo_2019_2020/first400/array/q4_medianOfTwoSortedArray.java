package repo_2019_2020.first400.array;

public class q4_medianOfTwoSortedArray {
    /**
     *Analysis:
     * In order to solve this question, we need to first understand what a median is. A median is the middle value of a dataset.
     * Since we have 2 seperately sorted array in this question, to find the middle value is somewhat complicated. However, keep in mind that we do not care about the actual value of the numbers, what we want is the middle point from the combination of 2 arrays. In other words, we are looking for the middle index of the 2 arrays. Thus approach like binary search could be employed.
     * Based on the fact that the 2 arrays are sorted seperatedly, we could try to get the submedian of the 2 arrays in each round. Than compare them.
     *
     * And the basic idea is that the left half of the array with a smaller submedian can never contains the common median.
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Deal with invalid corner case.
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0.0;

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2; //left half of the combined median
        int r = (m + n + 2) / 2; //right half of the combined median

        // If the nums1.length + nums2.length is odd, the 2 function will return the same number
        // Else if nums1.length + nums2.length is even, the 2 function will return the left number and right number that make up a median
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // This function finds the Kth element in nums1 + nums2

        // If nums1 is exhausted, return kth number in nums2
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];

        // If nums2 is exhausted, return kth number in nums1
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];

        // If k == 1, return the first number
        // Since nums1 and nums2 is sorted, the smaller one among the start point of nums1 and nums2 is the first one
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;
        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];

        // Throw away half of the array from nums1 or nums2. And cut k in half
        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2); //nums1.right + nums2
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2); //nums1 + nums2.right
        }
    }
    public static double findMedianSortedArraysNormal(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] nums3 = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[i + j] = nums1[i];
                i++;
            }else{
                nums3[i + j] = nums2[j];
                j++;
            }
        }

            while (i < nums1.length) {
                nums3[i + j] = nums1[i];
                i++;
            }

            while (j < nums2.length) {
                nums3[i + j] = nums2[j];
                j++;
            }


        if ((nums3.length) % 2 == 0) {
            return ((double)(nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1])) / 2;
        } else {
            return nums3[nums3.length / 2];
        }

    }

    public static void main(String[] args) {
        int[] t1 = new int[]{1,2,3};
        int[] t2 = new int[]{2,3,4};
        System.out.println(findMedianSortedArraysNormal(t1,t2));
    }

}
