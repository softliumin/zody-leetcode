package org.example.leetcode.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 求两个数组的交集
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 不考虑顺序
 * @author zody
 * @since 2020-07-02 21:01
 */
public class LeetCode0349 {

    public static void main(String[] args) {
        int[] nums1 = new int[] { 4, 9, 5 };
        int[] nums2 = new int[] { 9, 4, 9, 8, 4 };
        int[] temp = intersection(nums1, nums2);
        System.out.println(temp);
    }

    /**
     * 感觉还不够优雅
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[] {};
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x = 0; x < nums1.length; x++) {
            set.add(nums1[x]);
        }

        for (int x = 0; x < nums2.length; x++) {
            set2.add(nums2[x]);
        }

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer temp = it.next();
            if (set2.contains(temp)) {
                list.add(temp);
            }
        }

        int[] nums3 = new int[list.size()];
        for (int x = 0; x < list.size(); x++) {
            nums3[x] = list.get(x);
        }
        return nums3;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {

        return null;
    }

}
