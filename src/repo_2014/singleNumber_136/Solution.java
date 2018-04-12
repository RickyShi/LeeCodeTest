package repo_2014.singleNumber_136;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Using Set
     */
    public int singleNumberSet(int[] nums) {
        int rtn = -1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                set.remove(i);
            }
        }
        for (int i : set) {
            rtn = i;
        }
        return rtn;
    }

    /**
     * Approach #4 Bit Manipulation [Accepted]
     * Concept
     * <p>
     * If we take XOR of zero and some bit, it will return that bit
     * a \oplus 0 = aa⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a \oplus a = 0a⊕a=0
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * So we can XOR all bits together to find the unique number.
     */
    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= A[i];
        }
        return result;
    }
}
