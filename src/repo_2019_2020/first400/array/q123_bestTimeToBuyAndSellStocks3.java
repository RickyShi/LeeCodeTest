package repo_2019_2020.first400.array;

public class q123_bestTimeToBuyAndSellStocks3 {
    /**
     * O(n2)
     * Brute Force
     */
    public static int maxProfitBAD(int[] prices) {
        int max = 0;
        int maxFirst = 0;
        int minIndexFirst = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - prices[minIndexFirst];
            if (profit > maxFirst) {
                maxFirst = profit;
            }
            if (prices[i] < prices[minIndexFirst]) {
                minIndexFirst = i;
            }
            // Deal with the boundary part
            if (i == prices.length - 1) {
                max = max > maxFirst ? max : maxFirst;
            } else {
                int maxSecond = 0;
                int minIndexSecond = i + 1;
                for (int j = i + 1; j < prices.length; j++) {
                    profit = prices[j] - prices[minIndexSecond];
                    if (profit > maxSecond) {
                        maxSecond = profit;
                    }
                    if (prices[j] < prices[minIndexSecond]) {
                        minIndexSecond = j;
                    }
                    if (maxFirst + maxSecond > max) {
                        max = maxFirst + maxSecond;
                    }
                }
            }
        }
        return max;
    }

    /**
     * O(n) Space:O(2n)
     * Using 2 array to store the max profit from beginning and other from end. Then did a loop to calculate the max value.
     */
    public static int maxProfit(int[] prices) {
        int[] fromStart = new int[prices.length];
        int[] toEnd = new int[prices.length];
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
            fromStart[i] = max;
        }
        int maxIndex = prices.length - 1;
        max = 0;
        for (int j = prices.length - 1; j > 0; j--) {
            int profit = prices[maxIndex] - prices[j];
            if (profit > max) {
                max = profit;
            }
            if (prices[j] > prices[maxIndex]) {
                maxIndex = j;
            }
            toEnd[j] = max;
        }
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            int profit;
            if (i + 1 < prices.length) {
                profit = fromStart[i] + toEnd[i + 1];
            } else {
                profit = fromStart[i];
            }

            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }

    /**
     * O(n) Space O(n)
     *
     */
    public static int maxProfitBest(int[] prices) {
        int[] tmp = new int[prices.length];
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
            tmp[i] = max;
        }
        int maxIndex = prices.length - 1;
        max = 0;
        for (int j = prices.length - 1; j >= 0; j--) {
            int profit = prices[maxIndex] - prices[j];
            if (profit > max) {
                max = profit;
            }
            if (prices[j] > prices[maxIndex]) {
                maxIndex = j;
            }
            if (j > 0) {
                tmp[j] = max + tmp[j - 1];
            } else {
                tmp[j] = max;
            }
        }
        max = 0;
        for (int i = 0; i < prices.length; i++) {

            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] anArray = { 100, 10, 2, 400, 500, 60, 700, 800, 900, 1000 };
        System.out.println(maxProfitBAD(anArray));
        System.out.println(maxProfit(anArray));
        System.out.println(maxProfitBest(anArray));
    }
}
