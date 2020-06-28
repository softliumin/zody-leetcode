/**
 * @(#)LeetCode0007.java, 2020/6/28.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.example.leetcode.java;

/**
 * Reverse Integer
 * 题目地址 https://leetcode.com/problems/reverse-integer/
 * 要注意溢出
 *
 * @author zody
 * @since 2020-06-28 15:55
 */
public class LeetCode0007 {
    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            if (Math.abs(reversed) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed;
    }
}
