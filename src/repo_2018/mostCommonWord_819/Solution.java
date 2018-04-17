package repo_2018.mostCommonWord_819;

import java.util.*;

public class Solution {
    public static void main(String[] args){
//        String s = "a b!?',;.";
//        String s = "\"Bob hit a ball, the hit BALL flew far after it was hit.\"";
//        s = s.replaceAll("[!]|[?]|[']|[,]|[;]|[.]","");
//        s = s.replaceAll("[!?',;.]","");
//        s = s.replaceAll("\\p{Punct}","");
//        s = s.replaceAll("\\pP","");
//        System.out.println(s);
//        System.out.println(mostCommonWordRicky("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));

       /* String[] banned =new String[]{"t","t","s"};
        Set<String> ban = new HashSet<>(Arrays.asList(banned));*/
    }

    /**
     * Using a set to reduce time and no need to loop keySet of hashMap
     * Compared to Ricky's one, this one is more clear and simple
     */
    public String mostCommonWord(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\pP" , "").toLowerCase().split("\\s+");
        String res = "";
        int max = 0;
        for (String w : words) {
            if (!ban.contains(w)) {
                count.put(w, count.getOrDefault(w, 0) + 1);
                if (count.get(w) > max) {
                    res = w;
                    max = count.get(w);
                }}}
        return res;
    }

    public static String mostCommonWordRicky(String paragraph, String[] banned) {
        String[] sa = paragraph.replaceAll("[!]|[?]|[']|[,]|[;]|[.]","").toLowerCase().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String s:sa){
            if(!isContains(s,banned)){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        String key ="";
        int max = 0;
        for(String i:map.keySet()){
            if(map.get(i)>max) {
                max = map.get(i);
                key = i;
            }
        }
        return key;
    }

    public static boolean isContains(String s, String[] array){
        for(String t:array){
            if (s.equals(t)){
                return true;
            }
        }
        return false;
    }
}
