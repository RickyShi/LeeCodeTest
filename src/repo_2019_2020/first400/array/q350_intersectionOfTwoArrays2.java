package repo_2019_2020.first400.array;

import java.util.*;

public class q350_intersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * Algorithm
     * <p>
     * Sort nums1 and nums2.
     * <p>
     * Initialize i, j and k with zero.
     * <p>
     * Move indices i along nums1, and j through nums2:
     * <p>
     * Increment i if nums1[i] is smaller.
     * <p>
     * Increment j if nums2[j] is smaller.
     * <p>
     * If numbers are the same, copy the number into nums1[k], and increment i, j and k.
     * <p>
     * Return first k elements of nums1.
     */
    public int[] intersectTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k++] = nums1[i++];
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersectRicky(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }

        if (map1.size() < map2.size()) {
            return intersectRTN(map1, map2);
        } else {
            return intersectRTN(map2, map1);
        }
    }

    public int[] intersectRTN(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        List<Integer> list = new ArrayList<>();
        for (int key : map1.keySet()) {
            for (int i = 0; i < Math.min(map1.getOrDefault(key, 0), map2.getOrDefault(key, 0)); i++) {
                list.add(key);
            }
        }
        return convertListToArray(list);
    }

    private int[] convertListToArray(List<Integer> list) {

        int[] rtn = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rtn[i] = list.get(i);
        }
        return rtn;
    }
}
