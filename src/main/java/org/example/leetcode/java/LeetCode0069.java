package org.example.leetcode.java;

/**
 * Sqrt(x)
 * https://leetcode-cn.com/problems/sqrtx/
 * x 的平方根
 * @author zody
 * @since 2020-08-01 15:55
 */
public class LeetCode0069 {

    public static void main(String[] args) {
        System.out.println(new LeetCode0069().mySqrt(16));
    }

    public int mySqrt(int x) {
        int left = 0, right = x / 2 + 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
