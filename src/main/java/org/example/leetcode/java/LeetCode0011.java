package org.example.leetcode.java;

/**
 * 第一次尝试中等难度的题目
 *
 * @author zody
 * @since 2020-07-06 13:37
 */
public class LeetCode0011 {

    public static void main(String[] args) {

    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            // 求出左右之间的面积
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);

            // 左边比较低，就做中间挪动
            if (height[l] <= height[r]) {
                ++l;
            } else {
                // 右边低，就像中间挪动
                --r;
            }
        }
        return ans;
    }
}
