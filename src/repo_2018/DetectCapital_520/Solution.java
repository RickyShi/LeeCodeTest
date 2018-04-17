package repo_2018.DetectCapital_520;

public class Solution {

    public boolean detectCapitalUseSmple(String word) {
        int cnt = 0;
        for(char c: word.toCharArray()) if(Character.isUpperCase(c)) cnt++;
        return ((cnt==0 || cnt==word.length()) || (cnt==1 && 'Z' - word.charAt(0)>=0));
    }

    public boolean detectCapitalUse(String word) {
        if (word==null||word.isEmpty()) return false;
        if (word.length()==1) return true;
        char[] ca = word.toCharArray();
        if (Character.isLowerCase(ca[0])){
            for (int i=1;i<ca.length;i++){
                if (Character.isUpperCase(ca[i])){
                    return false;
                }
            }
            return true;
        }else if (Character.isUpperCase(ca[0])){
            if (word.length()==2) return true;
            if (Character.isLowerCase(ca[1])){
                for (int i=2;i<ca.length;i++){
                    if (Character.isUpperCase(ca[i])){
                        return false;
                    }
                }
                return true;
            }
            if (Character.isUpperCase(ca[1])){
                for (int i=2;i<ca.length;i++){
                    if (Character.isLowerCase(ca[i])){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
