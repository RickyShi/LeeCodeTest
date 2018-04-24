package repo_2018.rangeAddtion2_598;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {

        for (int[] a:ops){
            m = Math.min(a[0],m);
            n = Math.min(a[1],n);
        }
        return m*n;
    }
}
