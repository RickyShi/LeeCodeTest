package repo_2018.romanToInteger_13;

public class Solution {

    public int romanToIntRicky(String s) {
        int rtn = 0;
        char[] array = s.toCharArray();
        for (int i=0;i<array.length-1;i++){
            if ((array[i]=='I'&&(array[i+1]=='V'||array[i+1]=='X'))
                    ||(array[i]=='X'&&(array[i+1]=='L'||array[i+1]=='C'))
                    ||(array[i]=='C'&&(array[i+1]=='D'||array[i+1]=='M')) ){
                rtn-=singleRomanToInt(array[i]);
            }else{
                rtn += singleRomanToInt(array[i]);
            }
        }
        rtn+=singleRomanToInt(array[array.length-1]);
        return rtn;
    }

    public int singleRomanToInt(char c){
        int rtn = 0;
        switch(c){
            case 'I': rtn =1;
                break;
            case 'V': rtn =5;
                break;
            case 'X': rtn =10;
                break;
            case 'L': rtn =50;
                break;
            case 'C': rtn =100;
                break;
            case 'D': rtn =500;
                break;
            case 'M': rtn =1000;
                break;
        }
        return rtn;
    }

    public  int romanToIntReverse(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.romanToIntRicky("IX"));
    }
}
