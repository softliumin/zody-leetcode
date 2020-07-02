package org.example.leetcode.java;

/**
 * @author zody
 * @since 2020-07-02 17:47
 */
public class LeetCode0026 {
    public static void main(String[] args) {

        int[] nums = new int[] { 1, 1, 2 };
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // 使用双指针
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

}
