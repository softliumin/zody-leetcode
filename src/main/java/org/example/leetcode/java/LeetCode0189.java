package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * Rotate Array
 * @author zody
 * @since 2020-07-29 12:25
 */
public class LeetCode0189 {
    public static void main(String[] args) {
        LeetCode0189 leetCode0189 = new LeetCode0189();

        int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        leetCode0189.rotate(nums, 3);
        for (int x = 0; x < nums.length; x++) {
            System.out.print(nums[x] + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 使用环状替换
     * 时间复杂度：O(n) 。 n 个元素被反转了总共 3 次
     * 空间复杂度：O(1) 。 没有使用额外的空间。
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * ：使用额外的数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 暴力
     * O(n*k)
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

}
