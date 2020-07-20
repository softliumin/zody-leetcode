package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 买卖股票最佳时机
 * @author zody
 * @since 2020-07-20 12:31
 */
public class LeetCode0121 {
    public static void main(String[] args) {

        int[] prices = new int[] { 7, 6, 4, 3, 1 };
        //        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        if (null == prices || prices.length == 0) {
            return max;
        }

        for (int x = 0; x < prices.length; x++) {
            for (int y = x + 1; y < prices.length; y++) {
                int temp = prices[x] - prices[y];
                if (temp < 0) {
                    if (Math.abs(temp) >= max) {
                        max = Math.abs(temp);
                    }
                }
            }
        }
        return max;
    }

    /**
     * 运行时间大大降低
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

}
