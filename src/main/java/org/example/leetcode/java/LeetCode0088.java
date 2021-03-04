package org.example.leetcode.java;

import java.util.Arrays;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-03-04 10:24
 */
public class LeetCode0088 {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = nums2.length;

        merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ":");
        }
    }

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * 时间复杂度 m+n
     * 空间复杂度 m+n
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {

            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
// 逆向双指针 TODO

    /**
     * 插入排序
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; ++i) {
            int temp = nums2[i - m];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (temp < nums1[j]) {
                    nums1[j + 1] = nums1[j];
                    continue;
                }
                break;
            }
            nums1[j + 1] = temp;
        }
    }


}
