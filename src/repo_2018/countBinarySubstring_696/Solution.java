package repo_2018.countBinarySubstring_696;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "00110";

        System.out.println(solution.countBinarySubstrings1(input));
    }

    /**
     * Approach #1: Group By Character [Accepted]
     * Intuition
     * <p>
     * We can convert the string s into an array groups that represents the length of same-character contiguous blocks within the string. For example, if s = "110001111000000", then groups = [2, 3, 4, 6].
     * <p>
     * For every binary string of the form '0' * k + '1' * k or '1' * k + '0' * k, the middle of this string must occur between two groups.
     * <p>
     * Let's try to count the number of valid binary strings between groups[i] and groups[i+1]. If we have groups[i] = 2, groups[i+1] = 3, then it represents either "00111" or "11000". We clearly can make min(groups[i], groups[i+1]) valid binary strings within this string. Because the binary digits to the left or right of this string must change at the boundary, our answer can never be larger.
     * <p>
     * Algorithm
     * <p>
     * Let's create groups as defined above. The first element of s belongs in it's own group. From then on, each element either doesn't match the previous element, so that it starts a new group of size 1; or it does match, so that the size of the most recent group increases by 1.
     * <p>
     * Afterwards, we will take the sum of min(groups[i-1], groups[i]).
     */
    public int countBinarySubstrings1(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            ans += Math.min(groups[i - 1], groups[i]);
        }
        return ans;
    }

    /**
     * Approach #2: Linear Scan [Accepted]
     * Intuition and Algorithm
     *
     * We can amend our Approach #1 to calculate the answer on the fly. Instead of storing groups, we will remember only prev = groups[-2] and cur = groups[-1]. Then, the answer is the sum of min(prev, cur) over each different final (prev, cur) we see.
     * prev: prev group length
     * cur:  cur  group length
     */
    public int countBinarySubstrings2(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        /** Don't forget the last case*/
        return ans + Math.min(prev, cur);
    }

}
