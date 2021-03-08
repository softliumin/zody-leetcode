package org.example.offer;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 动态规划 爬楼梯
 *
 * @author 柳敏 minliu
 * @since 2021-02-20 17:39
 */
public class Offer70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
