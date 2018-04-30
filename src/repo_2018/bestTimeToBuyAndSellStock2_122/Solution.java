package repo_2018.bestTimeToBuyAndSellStock2_122;

public class Solution {

    /**
     * Approach #1 Brute Force [Time Limit Exceeded]
     * In this case, we simply calculate the profit corresponding to all the possible sets of transactions and find out the maximum profit out of them.
     */
    class BruteForce {
        public int maxProfit(int[] prices) {
            return calculate(prices, 0);
        }

        public int calculate(int prices[], int s) {
            if (s >= prices.length)
                return 0;
            int max = 0;
            for (int start = s; start < prices.length; start++) {
                int maxprofit = 0;
                for (int i = start + 1; i < prices.length; i++) {
                    if (prices[start] < prices[i]) {
                        int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                        if (profit > maxprofit)
                            maxprofit = profit;
                    }
                }
                if (maxprofit > max)
                    max = maxprofit;
            }
            return max;
        }
    }

    /**
     * Approach #2 (Peak Valley Approach) [Accepted]
     * If we analyze the graph, we notice that the points of interest are the consecutive valleys and peaks.
     * The key point is we need to consider every peak immediately following a valley to maximize the profit. In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to an overall lesser profit.
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
     */
    class PeakValleyApproach {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length == 0) return 0;
            int i = 0;
            int valley = prices[0];
            int peak = prices[0];
            int maxProfit = 0;
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                    i++;
                }
                valley = prices[i];
                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                peak = prices[i];
                maxProfit += peak - valley;
            }
            return maxProfit;
        }
    }

    /**
     * Approach #3 (Simple One Pass) [Accepted]
     * Algorithm
     * <p>
     * This solution follows the logic used in Approach 2 itself, but with only a slight variation. In this case, instead of looking for every peak following a valley, we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction. In the end,we will be using the peaks and valleys effectively, but we need not track the costs corresponding to the peaks and valleys along with the maximum profit, but we can directly keep on adding the difference between the consecutive numbers of the array if the second number is larger than the first one, and at the total sum we obtain will be the maximum profit. This approach will simplify the solution
     */
    class OnePass {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }
    }

}
