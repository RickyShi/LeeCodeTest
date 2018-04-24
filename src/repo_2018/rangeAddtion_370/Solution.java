package repo_2018.rangeAddtion_370;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * <p>
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * <p>
 * Return the modified array after all k operations were executed.
 * <p>
 * Example:
 * <p>
 * Given:
 * <p>
 * length = 5,
 * updates = [
 * [1,  3,  2],
 * [2,  4,  3],
 * [0,  2, -2]
 * ]
 * <p>
 * Output:
 * <p>
 * [-2, 0, 3, 5, 3]
 * Explanation:
 * <p>
 * Initial state:
 * [ 0, 0, 0, 0, 0 ]
 * <p>
 * After applying operation [1, 3, 2]:
 * [ 0, 2, 2, 2, 0 ]
 * <p>
 * After applying operation [2, 4, 3]:
 * [ 0, 2, 5, 5, 3 ]
 * <p>
 * After applying operation [0, 2, -2]:
 * [-2, 0, 3, 5, 3 ]
 */
public class Solution {

    /**
     * O(K*N) too complex
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        if (updates == null || updates.length == 0) return result;

        for (int[] update : updates) {
            for (int i = update[0]; i <= update[1]; i++) {
                result[i] += update[2];
            }
        }
        return result;
    }

    /**
     * Hint:
     *
     * Thinking of using advanced data structures? You are thinking it too complicated.
     * For each update operation, do you really need to update all elements between i and j?
     * Update only the first and end element is sufficient.
     * The optimal time complexity is O(k + n) and uses O(1) extra space.
     * 思想是把所有需要相加的值存在第一个数，然后把这个范围的最后一位的下一位减去这个inc, 这样我所以这个范围在求最终值的时候，都可以加上这个inc，而后面的数就不会加上inc。
     */
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0], end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;
            if (end < length - 1) {
                result[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        long startTime = System.nanoTime();
        for (int i:solution.getModifiedArray(5,updates)) {
            System.out.print(i+" ");
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        startTime = System.nanoTime();
        for (int i:solution.getModifiedArray2(5,updates)) {
            System.out.print(i+" ");
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
