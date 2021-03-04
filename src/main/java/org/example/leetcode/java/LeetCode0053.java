package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * Maximum Subarray
 *
 * @author zody
 * @since 2020-08-01 15:36
 */
public class LeetCode0053 {


    public static void main(String[] args) {

        /**
         *  [4,-1,2,1] 的和最大，为 6
         */
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new LeetCode0053().maxSubArray(nums));
    }

    /**
     * 最大子序和
     * 时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
            if (sum > 0) {
                sum = sum + num;
            } else {
                //sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
