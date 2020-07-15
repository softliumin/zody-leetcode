package org.example.leetcode.java;

/**
 * 搜索插入位置
 * @author zody
 * @since 2020-07-06 13:10
 */
public class LeetCode0035 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        // 直接等于
        for (int x = 0; x < nums.length; x++) {
            if (target == nums[x]) {
                return x;
            }
        }

        // 进行插入
        for (int x = 0; x < nums.length; x++) {
            if (target <= nums[x]) {
                return x;
            } else {
                if ((x + 1) < nums.length) {
                    if (target > nums[x] && target < nums[x + 1]) {
                        return x+1;
                    }
                } else {
                    return nums.length;
                }
            }
        }
        return 0;
    }

}



