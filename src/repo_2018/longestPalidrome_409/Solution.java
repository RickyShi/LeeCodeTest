package repo_2018.longestPalidrome_409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        boolean existSingle = false;
        int count = 0;
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                count += map.get(key);
            } else {
                count += map.get(key) - 1;
                existSingle = true;
            }
        }
        return existSingle ? count + 1 : count;
    }
}
