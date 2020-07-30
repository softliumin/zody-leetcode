package org.example.leetcode.java;

import java.util.Stack;

/**
 * Min Stack
 * https://leetcode-cn.com/problems/min-stack/
 * @author zody
 * @since 2020-07-30 09:05
 */
public class LeetCode0155 {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * 最小栈
     */
    public class MinStack {

        private Stack<Integer> stack;

        public MinStack() {
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                stack.push(x);
            } else {
                int tmp = stack.peek();
                stack.push(x);
                if (tmp < x) {
                    stack.push(tmp);
                } else {
                    stack.push(x);
                }
            }
        }

        /**
         * 删除栈顶元素
         */
        public void pop() {
            stack.pop();
            stack.pop();
        }

        /**
         * 获取栈顶元素
         * @return
         */
        public int top() {
            return stack.get(stack.size() - 2);
        }

        /**
         * 获取最小元素
         * @return
         */
        public int getMin() {
            return stack.peek();
        }
    }
}

class MinStack2 {
    private Node head;

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;

        int min;

        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

class MinStack3 {
    public Integer[] root;

    //栈内元素个数
    public int n;

    //保存一个值作为最小值
    public Integer min;

    /**
     * initialize your data structure here.
     */
    public MinStack3() {
        root = new Integer[30];
    }

    public void push(int x) {
        //自动扩容机制, 使用了System.arraycopy 函数
        if (n >= root.length - 1) {
            Integer[] newRoot = new Integer[root.length * 2];
            System.arraycopy(root, 0, newRoot, 0, root.length);
            root = newRoot;
        }
        root[n] = x;
        // min 判定并赋值最小值
        if (min == null || min > x) {
            min = x;
        }
        n++;
    }

    public void pop() {
        if (n == 0) {
            return;
        }
        root[n - 1] = null;
        n--;
        if (n == 0) {
            min = null;
            return;
        }
        min = root[0];
        //牺牲了pop的时间复杂度
        for (int i = 0; i < n; i++) {
            if (min > root[i]) {
                min = root[i];
            }
        }
    }

    public Integer top() {
        if (n == 0) {
            return null;
        }
        return root[n - 1];
    }

    public int getMin() {
        return min;
    }
}
