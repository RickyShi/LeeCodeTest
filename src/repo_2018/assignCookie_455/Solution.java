package repo_2018.assignCookie_455;

import java.util.Arrays;

public class Solution {
    public int findContentChildrenRicky(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(g.length==0||s.length==0||g[0]>s[s.length-1]) return 0;
        int i=0,j=0,rtn=0;
        while(i<g.length&&j<s.length){
            if(g[i]<=s[j]){
                rtn++;
                i++;
            }
            j++;
        }
        return rtn;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] g = new int[]{10,9,8,7};
        int[] s = new int[]{5,6,7,8};
        System.out.println(solution.findContentChildrenRicky(g,s));
    }

}
