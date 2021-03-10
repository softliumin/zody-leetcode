package org.example.leetcode.java;

/**
 * @author 柳敏 
 * @since 2021-03-09 19:43
 */
public class LeetCode0283 {


    public static void main(String[] args) {
        int[] tt = {1, 0, 12, 3, 0};
        moveZeroes(tt);
        System.out.println();
    }

    public static void moveZeroes2(int[] nums) {
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                if (nums[x] == 0) {
                    int temp = nums[y];
                    nums[y] = nums[x];
                    nums[x] = temp;
                }
            }
        }
    }


    // 双指针  不等于0就往左挪动
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
        // 当是一个元素时候，会出现问题，所以必须判断
        if (left != right) {
            nums[right] = nums[right] + nums[left];
            nums[left] = nums[right] - nums[left];
            nums[right] = nums[right] - nums[left];
        }
    }


}
