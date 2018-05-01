package repo_2018.bestTimeToBuyAndSellStockWithCoolDown_309;

public class Solution {

    /**
     * 状态图 https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/126913/Java-Solution-time-O(n)-space-O(1)
     */
    /**
     * for any day[i], there are three possible state:
     * rest: means you don't have stock, be in this state by selling( then cooldown) or keep rest.
     * hold: means you have stock that not sold, be in this state by buying stock or keeping stock you have bought.
     * sold: means you sell stock, be in this state only by you have hold one stock and sell it.
     * <p>
     * rest[i] means the maxProfit on day[i] if in rest state , becasue we could be in this state by selling( then cooldown) or keep rest:
     * rest[i] = Max(sold[i-1], rest[i-1])
     * <p>
     * hold[i] means the maxProfit on day[i] if in hold state, becasue we could be in this state by buying stock or keep stock you have bought:
     * hold[i] = Max(rest[i-1] - price[i], hold[i-1])
     * <p>
     * sold[i] means the maxProfit on day[i] if in sold state, because we we could be in this state only by you have hold one stock and sell it:
     * sold[i] = hold[i-1] + price[i]f
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int rest = 0, hold = Integer.MIN_VALUE, sold = Integer.MIN_VALUE;
        for (int price : prices) {
            int newHold = Math.max(hold, rest - price); // hold->hold, rest->hold
            rest = Math.max(rest, sold); // rest->rest, sold->rest
            sold = hold + price; // hold->sold
            hold = newHold;
        }
        return Math.max(rest, sold);
    }


    /**
     * 和第一种相比更加简化
     * buy[i]  表示在第i天前最后一个操作是买，此时的最大收益
     * sell[i] 表示在第i天前最后一个操作是卖，此时的最大收益
     * rest[i] 表示在第i天前最后一个操作是冷冻期，此时的最大收益
     * <p>
     * 递推公式：
     * buy[i] = max(rest[i-1] - price, buy[i-1])
     * sell[i] = max(buy[i-1] + price, sell[i-1])
     * rest[i] = max(rest[i-1],buy[i-1],sell[i-1])
     * 然后buy rest buy 的情况不会出现 buy[i] <= rest[i]
     * so, rest[i] = max(sell[i-1],rest[i-1])
     * 然后 冷冻期存在 我们知道 rest[i] = sell[i-1]；
     * 递推式简化成两个：
     * buy[i] = max(sell[i-2] - price, buy[i-1])
     * sell[i] = max(buy[i-1] + price, sell[i-1])
     */
    public int maxProfit2(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
