package repo_2018.minimumIndexSumOfTwoLists_599;

import java.util.*;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> rtn = new ArrayList<>();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                count.put(list2[i], i + map1.get(list2[i]));
            }
        }
        int min = Collections.min(count.values());
        for (String k : count.keySet()) {
            if (count.get(k) == min) {
                rtn.add(k);
            }
        }
        return rtn.toArray(new String[rtn.size()]);

    }

    public String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {//a little bit faster than above method
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
