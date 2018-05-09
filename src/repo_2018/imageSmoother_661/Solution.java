package repo_2018.imageSmoother_661;

public class Solution {
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 1 && M[0].length == 1) return M;
        int[][] rtn = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int count = 0;
                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < M.length && c >= 0 && c < M[i].length) {
                            rtn[i][j] += M[r][c];
                            count++;
                        }
                    }
                }
                rtn[i][j] /= count;
            }
        }
        return rtn;
    }
}
