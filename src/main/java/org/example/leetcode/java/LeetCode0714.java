package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 * 买卖股票（带有手续费）
 * 输入 prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出 8
 *
 * @author 柳敏 minliu
 * @since 2021-02-23 09:43
 */
public class LeetCode0714 {

    public static void main(String[] args) {
        int[] temp = {1, 3, 2, 8, 4, 4};
        int fee = 2;

        System.out.println(maxProfit2(temp, fee));

    }


    // 贪心
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;

        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit = profit + prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    // 动态规划
    public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        // 卖
        int sell = 0;

        // 买
        int buy = -prices[0];

        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

    public static int maxProfit22(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }


    public int maxProfit3(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            if (prices[i] < min) {
                //未发生买卖时找到第一个最小数，如果发生过买卖则比较当前价格和上次卖出时的价格减去手续费
                min = prices[i];
            } else {
                if (prices[i] - fee > min) {
                    res = res + prices[i] - min - fee;
                    //当前的价格已经减过手续费，所以min的值应为当前价格减去手续费。
                    min = prices[i] - fee;
                }
            }
        }
        return res;
    }

}

