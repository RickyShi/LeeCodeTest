package repo_2018.uniqueMorseCodeWords_804;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mapFile = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set set = new HashSet<String>() ;

        for (String s: words){
            StringBuilder sb=new StringBuilder();
            for (char c:s.toCharArray()){
                sb = sb.append(mapFile[c-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
