package org.example.leetcode.java;

/**
 * 求最长相同前缀
 * 双层循环
 * @author zody
 * @since 2020-06-29 20:13
 */
public class LeetCode0014 {

    public static void main(String[] args) {

        String[] strs = new String[] { "", "" };
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }
        return res;
    }

}




