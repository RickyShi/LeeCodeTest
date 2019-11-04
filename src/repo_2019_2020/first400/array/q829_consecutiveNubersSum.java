package repo_2019_2020.first400.array;

public class q829_consecutiveNubersSum {
    /**
     * Approach #1: Brute Force [Time Limit Exceeded]
     * Intuition and Algorithm
     *
     * For each starting number, we scan forward until we meet or exceed the target N.
     * If we meet it, then it represents one way to write N as a sum of consecutive numbers.
     *
     * For example, if N = 6, and we scan forward from 1, we'll get 1 + 2 + 3 = 6 which contributes to the answer.
     * If we scan forward from 2, we'll get 2 + 3 + 4 (the first time that the sum is >= N) which is too big.
     */
    public int consecutiveNumbersSumBruteForce(int N) {
        int ans = 0;
        for (int start = 1; start <= N; ++start) {
            int target = N, x = start;
            while (target > 0){
                target = target - x;
                x++;
            }
            if (target == 0) ans++;
        }
        return ans;
    }

    /**
     * Approach #2: Mathematical (Naive) [Time Limit Exceeded]
     * Intuition and Algorithm
     * N=(x+1)+(x+2)+⋯+(x+k) => 2∗N=k(2∗x+k+1)
     */
    public int consecutiveNumbersSum(int N) {
        // 2N = k(2x + k + 1)
        int ans = 0;
        for (int k = 1; k <= 2*N; ++k)
            if (2 * N % k == 0) {
                int y = 2 * N / k - k - 1;
                if (y % 2 == 0 && y >= 0)
                    ans++;
            }
        return ans;
    }
}
