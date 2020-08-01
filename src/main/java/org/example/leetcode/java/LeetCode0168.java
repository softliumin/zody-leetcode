/**
 * @(#)LeetCode0168.java, 2020/8/1.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.example.leetcode.java;

/**
 * Excel Sheet Column Title
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * @author zody
 * @since 2020-08-01 09:50
 */
public class LeetCode0168 {

    public static void main(String[] args) {
        System.out.printf(new LeetCode0168().convertToTitle(48));
    }

    /**
     * 说白了还是关于字符串的练习
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

}
