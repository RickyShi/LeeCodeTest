package repo_2019_2020.first400.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q244_shortestWordDistance2 {
    /**
     * Algorithm: Use Hashmap to store the location of words(in list),
     * so that do not need iterate every element in shortest function.
     *
     * In the constructor of the class, we simply iterate over the given list of words and prepare a dictionary, mapping a word to all it's locations in the array.
     * Since we process all the words from left to right, we will get all the indices in a sorted order by default for all the words. So, we don't have to sort the indices ourselves.
     * Let's call the dictionary that we build, locations.
     * For a given pair of words, obtain the list of indices (appearances inside the original list/array of words). Let's call the two arrays loc1 and loc2.
     * Initialize two pointer variables l1 = 0 and l2 = 0.
     * For a given l1 and l2, we first update (if possible) the minimum difference (distance) till now i.e. dist = min(dist, abs(loc1[l1] - loc2[l2])). Then, we check if loc1[l1] < loc2[l2] and if this is the case, we move l1 one step forward i.e. l1 = l1 + 1. Otherwise, we move l2 one step forward i.e. l2 = l2 + 1.
     * We keep doing this until all the elements in the smaller of the two location arrays are processed.
     * Return the global minimum distance between the words.
     */
}

class WordDistance {
    private Map<String, ArrayList<Integer>> locations;

    public WordDistance(String[] words) {
        this.locations = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> loc = this.locations.getOrDefault(words[i], new ArrayList<Integer>());
            loc.add(i);
            this.locations.put(words[i], loc);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> loc1, loc2;

        // Location lists for both the words
        // the indices will be in SORTED order by default
        loc1 = this.locations.get(word1);
        loc2 = this.locations.get(word2);

        int i1 = 0, i2 = 0, minDiff = Integer.MAX_VALUE;
        while (i1 < loc1.size() && i2 < loc2.size()) {
            minDiff = Math.min(minDiff, Math.abs(loc1.get(i1) - loc2.get(i2)));
            if (loc1.get(i1) < loc2.get(i2)) {
                i1++;
            } else {
                i2++;
            }
        }
        return minDiff;
    }

    /**
     * Time limited Exceed, although O(n)
     */
    class WordDistance2 {
        private String[] words;

        public WordDistance2(String[] words) {
            this.words = words;
        }

        public int shortest(String word1, String word2) {
            int minLen = words.length;
            int i1 = -1, i2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    i1 = i;
                } else if (words[i].equals(word2)) {
                    i2 = i;
                }
                if (i1 != -1 && i2 != -1) {
                    minLen = Math.min(minLen, Math.abs(i1 - i2));
                }
            }
            return minLen;
        }
    }

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
}
