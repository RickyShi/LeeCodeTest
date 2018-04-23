package repo_2018.excelSheetColumnTitile_168;

public class Solution {
    public static void main(String[] args){
//        char c = (char) 'A'+25;
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(27));
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            /* n-- don't forget*/
            n--;
            char c = (char)('A'+n%26);
            sb.append(c);
            n=n/26;
        }
        return sb.reverse().toString();
    }
}
