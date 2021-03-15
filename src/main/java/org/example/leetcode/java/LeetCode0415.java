package org.example.leetcode.java;

/**
 * @author 柳敏
 * @since 2021-03-10 18:59
 */
public class LeetCode0415 {
    public static void main(String[] args) {
        System.out.println(addStrings("12345", "889"));
    }


    /**
     * 字符串数字相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;

            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }


}
