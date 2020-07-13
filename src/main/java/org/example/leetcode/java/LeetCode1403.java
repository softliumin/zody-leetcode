package org.example.leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先对数据排序，从最大的一边向另外一边处理
 * https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 * @author zody
 * @since 2020-07-11 08:57
 */
public class LeetCode1403 {
    public static void main(String[] args) {
        int[] nums = new int[] { 4, 4, 7, 6, 7 };
        List<Integer> result = minSubsequence(nums);
        System.out.println(result.size());
    }

    public static List<Integer> minSubsequence(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        int current = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            count += num;
        }

        for (int x = nums.length - 1; x >= 0; x--) {
            result.add(nums[x]);
            if ((current += nums[x]) - (count -= nums[x]) > 0) {
                break;
            }
        }
        return result;
    }
}
