package org.example.leetcode.java;

import java.util.Arrays;

/**
 * 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * TODO 这道题目值得好好复习
 *
 * @author 柳敏
 * @since 2021-03-25 14:08
 */
public class LeetCode0416 {

    public static void main(String[] args) {
        int[] tt = new int[]{1, 5, 11, 5};
        System.out.println(new LeetCode0416().canPartition(tt));
    }

    /**
     * 01背包问题
     * 时间复杂度O(n*target)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sumAll = Arrays.stream(nums).sum();
        if (sumAll % 2 == 1) {
            return false;
        }
        int target = sumAll / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        /**
         * 动态规划开始
         * 逆序
         * 如果dp[j]是true 那么 dp[j-nums[i]]也是真
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
