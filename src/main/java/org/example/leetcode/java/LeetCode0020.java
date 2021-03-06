package org.example.leetcode.java;

import java.util.Stack;

/**
 * Input: "{[]}"
 * Output: true
 * 判断是不是对称的括号组合
 *
 * @author zody
 * @since 2020-06-29 20:13
 */
public class LeetCode0020 {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        stack.push('a');
        stack.pop();
        stack.peek();
        stack.isEmpty();

        System.out.println(isValid("{[()]}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                // stack.isEmpty() 入参不是规范的参数
                // c != stack.pop()
                return false;
            }

        }
        return stack.isEmpty();
    }

}




