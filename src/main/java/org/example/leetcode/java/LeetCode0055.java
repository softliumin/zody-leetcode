package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * 跳跃游戏
 *
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-03-01 19:59
 */
public class LeetCode0055 {

    public static void main(String[] args) {

        int[] temp = {2, 3, 1, 1, 4};
        System.out.println(canJump(temp));
    }

    public static boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
