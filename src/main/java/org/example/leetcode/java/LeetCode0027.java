package org.example.leetcode.java;

/**
 * @author zody
 * @since 2020-07-02 17:47
 */
public class LeetCode0027 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 2;
        System.out.println(removeElement(nums,val));
    }

    /**
     * 移除元素
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
