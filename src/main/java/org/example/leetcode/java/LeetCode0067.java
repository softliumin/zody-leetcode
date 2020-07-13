package org.example.leetcode.java;

/**
 * @author zody
 * @since 2020-07-06 13:10
 */
public class LeetCode0067 {

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    /**
     * 二进制求和
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        int c = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        while (c > 0 || i >= 0 || j >= 0) {
            int valA = i >= 0 ? charA[i--] - '0' : 0;
            int valB = j >= 0 ? charB[j--] - '0' : 0;
            int sum = valA + valB + c;
            c = sum >> 1;
            sb.append(sum % 2);
        }
        return sb.reverse().toString();
    }

}



