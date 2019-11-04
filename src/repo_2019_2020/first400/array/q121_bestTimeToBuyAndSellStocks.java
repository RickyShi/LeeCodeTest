package repo_2019_2020.first400.array;

public class q121_bestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minIndex = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - prices[minIndex];
            if (profit > max) {
                max = profit;
            }
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }

        }
        return max;
    }

    public int maxProfit2(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
