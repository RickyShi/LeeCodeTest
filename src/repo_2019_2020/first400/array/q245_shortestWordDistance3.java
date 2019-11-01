package repo_2019_2020.first400.array;

public class q245_shortestWordDistance3 {
    /**
     * compared to q243 shortestWordDistance1, move the minLen assign/change statement inside the each if and remove else.
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int minLen = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
                if (i2 != -1 && i1 != i2) {
                    minLen = Math.min(minLen, Math.abs(i1 - i2));
                }
            }
            if (words[i].equals(word2)) {
                i2 = i;
                if (i1 != -1 && i1 != i2) {
                    minLen = Math.min(minLen, Math.abs(i1 - i2));
                }
            }

        }
        return minLen;
    }
}
