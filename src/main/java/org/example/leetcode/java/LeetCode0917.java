package org.example.leetcode.java;

/**
 * 仅仅反转字母
 *
 * @author zody
 * @since 2020-07-02 21:01
 */
public class LeetCode0917 {

    public static void main(String[] args) {

        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        // 输出
        // Qedo1ct-eeLg=ntse-T!
    }

    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char left = chars[i];
            char right = chars[j];
            if (Character.isLetter(left) && Character.isLetter(right)) {
                chars[i] = right;
                chars[j] = left;
                i++;
                j--;
            }
            if (!Character.isLetter(left)) {
                i++;
            }
            if (!Character.isLetter(right)) {
                j--;
            }
        }
        return String.valueOf(chars);
    }

}
