package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * Power of Two
 * @author zody
 * @since 2020-08-01 10:37
 */
public class LeetCode0231 {

    public static void main(String[] args) {
        System.out.println(new LeetCode0231().isPowerOfTwo(64));
    }

    /**
     * 判断方法参数是否是 2 的幂次方
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        int temp = 2;
        for (int x = 0; x < 64; x++) {
            temp = temp * 2;
            if (temp == n) {
                return true;
            }
            if (temp > n) {
                return false;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * 位运算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo3(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }

}
