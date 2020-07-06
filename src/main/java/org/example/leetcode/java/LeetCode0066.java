package org.example.leetcode.java;

/**
 * @author zody
 * @since 2020-07-06 13:10
 */
public class LeetCode0066 {
    public static void main(String[] args) {

        int[] temp = new int[]{4,3,2,9};
        System.out.println(plusOne(temp));
    }

    public static int[] plusOne(int[] digits) {
        for (int x = digits.length - 1; x >= 0; x--) {
            if (digits[x] != 9) {
                digits[x]++;
                return digits;
            }
            digits[x] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }

}



