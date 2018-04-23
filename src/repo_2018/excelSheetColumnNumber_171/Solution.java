package repo_2018.excelSheetColumnNumber_171;

public class Solution {
    public int titleToNumber(String s) {
        int rtn = 0;
        for (int i=0;i<s.length();i++){
            rtn+=(s.charAt(i)-'A'+1)*Math.pow(26,s.length()-i-1);
        }
        return rtn;
    }

    public int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
