package repo_2018.subDomainVisitCount_811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args){
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String s: subdomainVisits(input)) {
            System.out.println(s);
        }
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ls = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap();
        for (String s: cpdomains){
            String[] sArray = s.split("\\s+");
            int num = Integer.valueOf(sArray[0]);
            String domain = sArray[1];
            String[] domainArray = domain.split("\\.");
            int l = domainArray.length;
            String key = "";
            for (int i = l-1; i>=0 ;i--){
                if (i == l-1){
                    key = domainArray[i];
                }else{
                    key = (new StringBuilder(key)).insert(0,(domainArray[i]+".")).toString();
                }
                if (hm.containsKey(key)){
                    hm.put(key,hm.get(key)+num);
                }  else{
                    hm.put(key,num);
                }
            }
        }
        for (String key: hm.keySet()){
            ls.add(String.valueOf(hm.get(key))+" "+key);
        }
        return ls;
    }

    public List<String> subdomainVisitsJava8(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");//space
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
}
