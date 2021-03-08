package org.example.leetcode.java;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 用两个栈模拟队列（先入先出）
 *
 * @author 柳敏 minliu
 * @since 2021-03-05 11:17
 */
public class LeetCode0232 {
    public static void main(String[] args) {

    }


}


class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    /**
     * 移除并返回
     *
     * @return
     */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    /**
     * 返回
     *
     * @return
     */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    /**
     * 初始化出栈
     */
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
