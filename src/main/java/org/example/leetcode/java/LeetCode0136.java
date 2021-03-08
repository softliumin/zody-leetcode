package org.example.leetcode.java;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number/
 * 只出现一次的数字
 *
 * @author 柳敏 minliu
 * @since 2021-03-04 11:22
 */
public class LeetCode0136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 4, 2, 3, 4}));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        res = set.stream().findFirst().get();
        return res;
    }

    // 位运算 ？？ TODO
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
