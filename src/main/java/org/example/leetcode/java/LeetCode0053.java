package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * Maximum Subarray
 * @author zody
 * @since 2020-08-01 15:36
 */
public class LeetCode0053 {

    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(new LeetCode0053().maxSubArray(nums));
    }

    /**
     * 最大子序和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
