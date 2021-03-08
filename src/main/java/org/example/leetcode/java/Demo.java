package org.example.leetcode.java;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-03-06 00:16
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(new Demo().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        // 最大长度
        int len = 0;

        // 起点位置
        int start = 0;

        for (int i = 0; i < s.length(); ++i) {
            int cur = Math.max(getLen(s, i, i), getLen(s, i, i + 1));
            if (cur > len) {
                len = cur;
                start = i - (cur - 1) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    private int getLen(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;
    }


}
