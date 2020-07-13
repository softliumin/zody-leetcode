package org.example.leetcode.java;

/**
 * @author zody
 * @since 2020-07-13 10:18
 */
public class LeetCode0922 {

    public static void main(String[] args) {
        int[] a = new int[] { 4, 2, 5, 7 };
        int[] b = sortArrayByParityII(a);
        System.out.println(b);
    }

    /**
     * 下标和值，奇偶相同
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length - 1; i = i + 2) {
            if ((A[i] & 1) != 0) {
                while ((A[j] & 1) != 0) {
                    j = j + 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
