package org.example.leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 二叉树的层序遍历
 *
 * @author 柳敏
 * @since 2021-03-15 21:00
 */
public class LeetCode0102 {

    public static void main(String[] args) {


    }

    /**
     * 广度优先搜索
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * 用数组实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    /***
     * 深度优先搜索
     *  TODO
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {

        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
