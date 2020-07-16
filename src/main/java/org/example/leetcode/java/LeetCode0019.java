package org.example.leetcode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * Remove Nth Node From End of List
 * @author zody
 * @since 2020-07-16 12:57
 */
public class LeetCode0019 {

    public static void main(String[] args) {
        int n = 2;
        //        LeetCode0021.ListNode head = null;
        //        LeetCode0021.ListNode ss = removeNthFromEnd(head, n);
        //        System.out.println(ss);

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head4.next = head5;
        head3.next = head4;
        head2.next = head3;
        head1.next = head2;

        ListNode ss2 = removeNthFromEnd2(head1, n);
        System.out.println(ss2);
    }

    public static LeetCode0021.ListNode removeNthFromEnd(LeetCode0021.ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = head;
        Map<Integer, ListNode> m = new HashMap<Integer, ListNode>();
        int index = 1;
        while (temp != null) {
            m.put(index++, temp);
            temp = temp.next;
        }
        int size = m.size();
        if (size == 1) {
            return null;
        }

        if (n == 1) {
            m.get(size - 1).next = null;
        } else if (n == size) {
            head = head.next;
        } else {
            m.get(size - n).next = m.get(size - n + 2);
        }
        return head;
    }

    public static int removeNode(LeetCode0021.ListNode node, int n) {
        if (node.next == null) {
            return 1;
        }

        int m = removeNode(node.next, n);
        if (m == n) {
            if (m == 1) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return m + 1;
    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

