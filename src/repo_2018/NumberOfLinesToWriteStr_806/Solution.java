package repo_2018.NumberOfLinesToWriteStr_806;

public class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int length =0;
        int lines = 1;

        for (char c : S.toCharArray()){
            length += widths[c-'a'];
            if (length>100){
                length = widths[c-'a'];
                lines++;
            }
        }

        return new int[]{lines,length};

    }
}
