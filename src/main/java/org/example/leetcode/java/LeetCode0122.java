package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 买卖股票的最佳时机(多次买卖一支股票)
 * @author zody
 * @since 2020-07-20 12:53
 */
public class LeetCode0122 {
    public static void main(String[] args) {
        //        int[] prices = new int[] { 7, 6, 4, 3, 1 };
        //        System.out.println(maxProfit(prices));

        int[] prices2 = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices2));
    }

    /**
     * 峰谷
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

}
