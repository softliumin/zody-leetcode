package org.example.leetcode.java;

/**
 * Palindrome Number
 * 题目地址 https://leetcode.com/problems/palindrome-number/
 * 回文数
 *
 * @author zody
 * @since 2020-06-28 15:55
 */
public class LeetCode0009 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1281));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return x == reverse;
    }

    /**
     * 优化版本，检查一半数字就好了
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
    }
}
