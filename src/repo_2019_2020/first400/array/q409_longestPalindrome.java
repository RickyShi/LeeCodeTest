package repo_2019_2020.first400.array;

import java.util.HashMap;
import java.util.Map;

public class q409_longestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    //same idea, use hash map instead
    public int longestPalindrome2(String s) {
        Map<Character,Integer> map  = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        boolean existSingle = false;
        int count = 0;
        for(char key:map.keySet()){
            if(map.get(key)%2==0){
                count+=map.get(key);
            }else{
                count+=map.get(key)-1;
                existSingle = true;
            }
        }
        return existSingle?count+1:count;
    }
}
