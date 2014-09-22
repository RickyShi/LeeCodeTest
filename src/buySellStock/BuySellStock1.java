package buySellStock;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author Ricky
 *
 */
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
