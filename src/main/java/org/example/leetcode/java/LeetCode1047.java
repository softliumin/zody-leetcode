package org.example.leetcode.java;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * 删除字符串中的所有相邻重复项 Remove All Adjacent Duplicates In String
 *
 * @author 柳敏
 * @since 2021-03-09 11:05
 */
public class LeetCode1047 {
    public static void main(String[] args) {

    }

    /**
     * 输入 abbaca 输出 ca
     * 时间复杂度O(n)
     * 空间复杂度O(n) 或 O(1)
     *
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }

    /**
     * 用栈解决
     * 具体思路：
     * （1）从左往右把元素放进栈，
     * （1.1）发现和栈顶元素不一样就放进去，
     * （1.2）发现和栈顶元素一样就:移除栈顶元素，移除队列最左元素
     *
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!st.empty() && S.charAt(i) == st.peek()) {
                st.pop();
            } else {
                st.add(S.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        for (Character c : st) {
            res.append(c);
        }
        return res.toString();
    }


}
