package repo_2018.intersectionOfTwoArray_349;

import java.util.*;

public class Solution {

    /**
     * two hash set
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i1 : nums1) {
            set.add(i1);
        }
        for (int i2 : nums2) {
            if (set.contains(i2)) {
                intersect.add(i2);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }

    /**
     * Sort both arrays, use two pointers
     * Time complexity: O(nlogn)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }

    /**
     * Binary search. two point: one beginning, one end.
     * Time complexity: O(nlogn)
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * 复杂了
     */
    public int[] intersectionRicky(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> ls = new ArrayList<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : set1) {
            if (set2.contains(i)) {
                ls.add(i);
            }
        }
//        return convertListToArray(ls);
        /** Java 8 easy way*/
        return ls.stream().mapToInt(i -> i).toArray();
    }

    private int[] convertListToArray(List<Integer> list) {

        int[] rtn = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rtn[i] = list.get(i);
        }
        return rtn;

    }
}
