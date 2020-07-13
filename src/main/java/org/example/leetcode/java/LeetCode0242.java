package org.example.leetcode.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * @author zody
 * @since 2020-07-07 09:11
 */
public class LeetCode0242 {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram2(s, t));
    }

    /**
     * 此方法不推荐
     * 判断两个单词是不是近似
     * @param s
     * @param t
     * @return
     */
    @Deprecated public static boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }

    /**
     * 计数器
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram3(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

}
