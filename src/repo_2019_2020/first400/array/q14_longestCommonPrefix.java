package repo_2019_2020.first400.array;

public class q14_longestCommonPrefix {
    /**
     * Approach 1: Horizontal scanning
     * Intuition
     * <p>
     * For a start we will describe a simple way of finding the longest prefix shared
     * LCP(S1..Sn)= LCP(LCP(LCP(s1,s2),s3)....sn)
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * Approach 2: Vertical scanning
     * Algorithm
     *
     * Imagine a very short string is at the end of the array. The above approach will still do SS comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to bottom on the same column (same character index of the strings) before moving on to the next column.
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
