package org.example.leetcode.java.bean;

import java.util.List;

/**
 * @author zody
 * @since 2020-07-21 19:59
 */
public class Node {
    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
