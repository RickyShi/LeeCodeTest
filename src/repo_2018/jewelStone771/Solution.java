package repo_2018.jewelStone771;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set s = new HashSet<Character>();
        int count = 0;
        for (char c1: J.toCharArray()){
            s.add(c1);
        }
        for (char c2: S.toCharArray()){
            if (s.contains(c2)){
                count++;
            }
        }
        return count;
    }
}
