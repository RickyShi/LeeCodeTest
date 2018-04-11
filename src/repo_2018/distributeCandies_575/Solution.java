package repo_2018.distributeCandies_575;

import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i:candies){
            if (!hs.contains(i)){
                hs.add(i);
            }
        }
        if (hs.size()>(candies.length/2)){
            return candies.length/2;
        } else{
            return hs.size();
        }
    }
}
