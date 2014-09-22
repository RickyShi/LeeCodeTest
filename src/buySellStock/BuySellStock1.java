package buySellStock;

public class BuySellStock1 {
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
}
