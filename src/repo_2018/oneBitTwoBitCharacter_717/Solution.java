package repo_2018.oneBitTwoBitCharacter_717;

public class Solution {
    /**
     * Approach #1: Increment Pointer [Accepted]
     * Intuition and Algorithm
     * <p>
     * When reading from the i-th position, if bits[i] == 0, the next character must have 1 bit; else if bits[i] == 1, the next character must have 2 bits. We increment our read-pointer i to the start of the next character appropriately. At the end, if our pointer is at bits.length - 1, then the last character must have a size of 1 bit.
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }


    /**
     * Approach #2: Greedy Method
     * Better method, no need to iterate whole string. Only the worst case.
     * If second element from last is 0: it is always true
     * if second element from last is 1: count the number of continuous 1's before last zero.
     * if the count turns out to be odd--false
     * otherwise--true
     */
    public boolean isOneBitCharacterGreedy1(int[] bits) {
        int count = 0;
        int length = bits.length;
        int i = length - 2;
        if (bits[i] == 0)
            return true;
        else {
            while (i >= 0 && bits[i] == 1) {
                count = count + 1;
                i = i - 1;
            }
            return count % 2 == 0;
        }
    }

    /**
     * Approach #3: Greedy [Accepted]
     * Intuition and Algorithm
     * 题目里说了最后一个必为0。所以可以想在倒数第二个0（或者没有就是开头）和最后一个之间的1必须是偶数个。
     * The second-last 0 must be the end of a character (or, the beginning of the array if it doesn't exist). Looking from that position forward, the array bits takes the form [1, 1, ..., 1, 0] where there are zero or more 1's present in total. It is easy to show that the answer is true if and only if there are an even number of ones present.
     * <p>
     * In our algorithm, we will find the second last zero by performing a linear scan from the right. We present two slightly different approaches below.
     */
    public boolean isOneBitCharacterGreedy2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) i--;
        return (bits.length - i) % 2 == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{1, 1, 1, 0};
        System.out.println(solution.isOneBitCharacterGreedy2(input));
    }
}
