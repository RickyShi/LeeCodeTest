package repo_2018.bestTimeToBuyAndSellStock_121;

public class Solution {

    /** Approach one pass, brute force method is not placed here*/
    public int maxProfit(int[] prices) {
        int max = 0;
        int minIndex = 0;
        for (int i=0; i<prices.length;i++){
            int profit = prices[i]-prices[minIndex];
            if (profit > max){
                max = profit;
            }
            if (prices[i] < prices[minIndex]){
                minIndex = i;
            }
        }
        return max;
    }
}
