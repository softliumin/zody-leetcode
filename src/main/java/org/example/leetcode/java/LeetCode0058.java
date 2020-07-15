package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * @author zody
 * @since 2020-07-15 09:49
 */
public class LeetCode0058 {

    public static void main(String[] args) {

        String str = "Hello World";
        System.out.println(lengthOfLastWord(str));
    }

    /**
     * 最后一个单词的长度
     * 总最后开始，小心最后的从空格就行
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }

}
