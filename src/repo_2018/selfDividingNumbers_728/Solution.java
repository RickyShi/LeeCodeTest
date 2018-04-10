package repo_2018.selfDividingNumbers_728;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ls = new ArrayList<>();
        for (int i=left;i<=right;i++){
            if (isSelfDividing(i)){
                ls.add(i);
            }
        }
        return ls;
    }

    public boolean isSelfDividing(int n){
        int x = n;
        while (x >0){
            int c = x % 10;
            if (c==0||(n % c != 0)){
                return false;
            }
            x = x/10;
        }
        return true;
    }
}
