package org.example.leetcode.java;

/**
 * 大写转小写
 *
 * @author zody
 * @since 2020-07-02 20:54
 */
public class LeetCode0709 {

    public static void main(String[] args) {

        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("LOVELY"));
    }

    public static String toLowerCase(String str) {
        if (str == null && "".equals(str)) {
            return null;
        }
        // 用函数直接实现（哈哈）
        // return str.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
