package repo_2018.rotatedDIgits_788;

public class Solution {
    /** 0,1,8 does not matter*/
    public int rotatedDigitsRicky(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count += isValid(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isValid(int i) {
        boolean flag = false;
        while (i > 0) {
            int t = i % 10;

            if (t == 3 || t == 4 || t == 7) return false;
            if (t == 2 || t == 5 || t == 6 || t == 9) flag = true;
            i = i / 10;
        }
        return flag;
    }

    public int rotatedDigits(int N) {
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (isRotated(i, N)) result++;
        }
        return result;
    }

    /**
     * Straight Forward Method Recalculate
     */
    private boolean isRotated(int N, int max) {
        int construct = 0;
        int level = 0;
        int original = N;
        while (N > 0) {
            int newV = 0;
            int remain = N % 10;
            N /= 10;
            level++;
            if (remain == 1) newV = 1;
            else if (remain == 0) newV = 0;
            else if (remain == 8) newV = 8;
            else if (remain == 2) newV = 5;
            else if (remain == 5) newV = 2;
            else if (remain == 6) newV = 9;
            else if (remain == 9) newV = 6;
            else return false;
            construct += newV * Math.pow(10, level - 1);
        }
        return construct != original;
    }


}
