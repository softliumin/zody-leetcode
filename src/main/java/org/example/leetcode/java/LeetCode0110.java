package org.example.leetcode.java;

/**
 * 判断高度平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-22 17:32
 */
public class LeetCode0110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }

    // 递归
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(helper(root.left) - helper(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        return Math.max(left, right) + 1;
    }


}


class TreeNode {
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
