package repo_2018.keyboardRow_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {
    public String[] findWords(String[] words) {

        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<strs.length;i++){
            for (char c: strs[i].toCharArray()){
                map.put(c,i);
            }
        }
        List<String> res = new ArrayList<>();
        for (String s: words){
            if (s.equals(" ")){
                continue;
            }
            int index = map.get(s.toUpperCase().charAt(0));

            for (char c:s.toUpperCase().toCharArray()){
                if (map.get(c)!=index){
                    index = -1;
                    break;
                }
            }

            if (index!=-1){
                res.add(s);
            }
        }

        return res.toArray(new String[0]);
    }

    public String[] findWordsLamda(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]+|[asdfghjkl]+|[zxcvbnm]+")).toArray(String[]::new);
    }
}
