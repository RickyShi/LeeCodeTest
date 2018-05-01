package repo_2018.bestTimeToBuyAndSellStock4_188;

public class Solution {

    /**
     * dp[i, j] represents the max profit up until prices[j] using at most i transactions.
     * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
     *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
     * dp[0, j] = 0; 0 transactions makes 0 profit
     * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
     * local max means the max profit of doing at most i-1 transactions, using at most first j-1 prices and
     * buying the stock at price[j] - this is used for the next loop
     */

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = /*dp[i-1][0]*/ - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                //j is also working
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
                //j-1 is also working
//                localMax = Math.max(localMax, dp[i-1][j-1] - prices[j]);
            }
         }
        return dp[k][n-1];
    }

    /**
     * just did not do optimization, just did loop instead of find prices[j] + max(dp[i-1, jj] - prices[jj])
     */
    public int maxProfitSlowSolution(int k, int[] prices) {
        int T[][] = new int[k+1][prices.length];

        for (int i =1; i<T.length;i++){
            for (int j =1;j<T[0].length;j++){
                int maxVal = 0;
                for (int m = 0; m < j; m++){
                    maxVal = Math.max(maxVal,prices[j]-prices[m]+T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1],maxVal);
            }
        }
        return T[k][prices.length-1];
    }
}
