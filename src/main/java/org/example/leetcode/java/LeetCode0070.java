package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 爬楼梯 动态规划
 * 这道题直白一点就是斐波拉切数列
 *
 * @author zody
 * @since 2020-07-06 13:35
 */
public class LeetCode0070 {

    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int climbStairs3(int n) {
        int a = 1;
        int b = 1;
        int result = 1;
        for (int x = 2; x <= n; x++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

}
