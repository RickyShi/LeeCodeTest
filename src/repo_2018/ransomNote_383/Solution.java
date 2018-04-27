package repo_2018.ransomNote_383;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.get(c) == null || map.get(c) < 1) return false;
            map.put(c, map.get(c) - 1);

        }
        return true;
    }

    public boolean canConstructArrayMethod(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("aa","ab"));

    }

}
