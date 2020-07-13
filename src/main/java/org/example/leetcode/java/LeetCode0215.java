package org.example.leetcode.java;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zody
 * @since 2020-07-13 15:38
 */
public class LeetCode0215 {

    public static void main(String[] args) {

        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int re = findKthLargest3(nums, 2);
        System.out.println(re);
    }

    /**
     * 先排序再查找
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 最小堆
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        final PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int val : nums) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快速排序
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest3(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int i = lo;
            for (int j = lo + 1; j <= hi; j++) {
                if (nums[j] < nums[lo]) {
                    swap(nums, j, ++i);
                }
            }
            swap(nums, lo, i);
            if (k == i) {
                return nums[i];
            } else if (k < i) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }

        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }

}
