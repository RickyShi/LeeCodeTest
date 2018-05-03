package repo_2018.twoSum3_DataStructureDesign_170;

import java.util.*;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * Example:
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 */
public class Solution {

    /**
     * each add need o(1) find O(n)
     */
    public class TwoSumHashMap {
        private Map<Integer, Integer> map;

        public TwoSumHashMap() {
            map = new HashMap<>();
        }

        public void add(int i) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        public boolean find(int target) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int i = entry.getKey();
                int j = target - i;
                if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                    return true;
                }
            }
            return false;
        }
    }

    /** just add another structure List*/
    public class TwoSum {
        private Map<Integer, Integer> map;
        private List<Integer> ls;

        public TwoSum() {
            map = new HashMap<>();
            ls = new ArrayList<>();
        }

        public void add(int i) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
                ls.add(i);
            } else {
                map.put(i, map.get(i) + 1);
            }

        }

        public boolean find(int target) {
            for (int num1 : ls) {
                int num2 = target - num1;
                if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * each add need o(nlgn) find O(n)
     */
    public class TwoSumOnlyList {
        private List<Integer> ls = new ArrayList<>();

        public void add(int i) {
            ls.add(i);
            Collections.sort(ls);
        }

        public boolean find(int target) {
            int i = 0, j = ls.size() - 1;
            while (i < j) {
                if (ls.get(i) + ls.get(j) == target) return true;
                if (ls.get(i) + ls.get(j) < target) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }
}
