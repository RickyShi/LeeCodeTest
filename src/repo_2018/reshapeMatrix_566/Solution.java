package repo_2018.reshapeMatrix_566;

public class Solution {

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        matrixReshape1(a, 4, 1);
    }

    /** easier and more simple */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }

    public static int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int x = 0;
        int y = 0;
        if (nums.length == 0 || nums.length * nums[0].length != r * c) return nums;
        for (int r1 = 0; r1 < nums.length; r1++) {
            for (int c1 = 0; c1 < nums[0].length; c1++) {
                if (x > c - 1) {
                    x = 0;
                    y++;
                }
                res[y][x] = nums[r1][c1];
                x++;
            }
        }
        return res;
    }
}
