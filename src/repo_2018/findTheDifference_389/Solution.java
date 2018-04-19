package repo_2018.findTheDifference_389;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public char findTheDifference(String s, String t) {

        Map<Character,Integer> map = new HashMap<>();

        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for (char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)-1);
        }

        for (char c :map.keySet()){
            if(map.get(c)==-1){
                return c;
            }
        }
        return '0';
    }

    /**
     * Could use XoR ^
     */
    public char findTheDifferenceXoR(String s, String t) {
        int n = t.length();
        char c = t.charAt(n - 1);
        for (int i = 0; i < n - 1; ++i) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
