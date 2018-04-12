package repo_2018.toeplitzMatrix_766;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
//        int[][] input = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
//        int[][] input = {{41,45}, {81,41}, {73,81},{47,73},{76,47},{79,76}};
    int[][] input = {{83},{64},{57}};
       /* System.out.println(input[0][0]);
        System.out.println(input[0][1]);
        System.out.println(input[0][2]);
        System.out.println(input[0][3]);
        System.out.println(input[1][0]);*/
        System.out.println(isToeplitzMatrix(input));
    }

    /** Approach #0: traverse by diagonal way
     * Time O(M*N) Space O(1)
     * */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int x = 0; x < matrix[0].length; x++) {
            int v = matrix[0][x];
            for (int y = 1; y < Math.min(matrix[0].length - x, matrix.length); y++) {
//                int k = matrix[y][x + y];
                if (matrix[y][x + y] != v) {
                    return false;
                }
            }
        }
        for (int y = 1; y < matrix.length; y++) {
            int v = matrix[y][0];
            for (int x = 1; x < Math.min(matrix[0].length, matrix.length - y); x++) {
//                int k = matrix[x + y][x];
                if (matrix[x + y][x] != v) {
                    return false;
                }
            }
        }

        return true;
    }

    /** same idea as 0, yet more simple*/
    public boolean isToeplitzMatrix2(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }

    /**Approach #1: Group by Category [Accepted]
     Intuition and Algorithm

     Time O(M*N) Space O(M*N) Take more space

     We ask what feature makes two coordinates (r1, c1) and (r2, c2) belong to the same diagonal?

     It turns out two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2.

     This leads to the following idea: remember the value of that diagonal as groups[r-c]. If we see a mismatch, the matrix is not Toeplitz; otherwise it is.*/
    public boolean isToeplitzMatrix1(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }
}
