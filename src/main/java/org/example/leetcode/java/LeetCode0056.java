package org.example.leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * 合并区间
 * java 数组用的还是不熟悉
 *
 * @author 柳敏
 * @since 2021-03-11 19:27
 */
public class LeetCode0056 {
    public static void main(String[] args) {

    }

    public static int[][] merge(int[][] intervals) {
        // 先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });


        //
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


}
