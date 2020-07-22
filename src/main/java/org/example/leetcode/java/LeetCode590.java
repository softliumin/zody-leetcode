package org.example.leetcode.java;

import org.example.leetcode.java.bean.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * N叉树的后续遍历
 * @author zody
 * @since 2020-07-21 19:57
 */
public class LeetCode590 {
    public static void main(String[] args) {
        LeetCode590 demo = new LeetCode590();
        demo.postorder(null);

    }

    List<Integer> result = new ArrayList<>();

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return result;
        }
        //先遍历子节点
        if (root.children != null) {
            for (Node node : root.children) {
                //递归，将子节点作为根节点传入postorder函数遍历
                postorder(node);
            }
        }
        //访问根节点
        result.add(root.val);
        return result;
    }



}



