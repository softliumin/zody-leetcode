/**
 * @(#)LeetCode0083.java, 2020/7/23.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.example.leetcode.java;

import org.example.leetcode.java.bean.ListNode;

/**
 * @author 柳敏 liumin06@corp.netease.com
 * @since 2020-07-23 20:36
 */
public class LeetCode0083 {

    public static void main(String[] args) {
        LeetCode0083 leetCode0083 = new LeetCode0083();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = leetCode0083.deleteDuplicates(l1);
        System.out.println(l4);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        //        if (head == null || head.next == null){
        //            return head;
        //        }
        //        ListNode temp = head;
        //        while (null != temp && null != temp.next) {
        //            if (temp.next.val == temp.val) {
        //                head.next = head.next.next;
        //            }else{
        //                temp = temp.next;
        //            }
        //        }
        //        return head;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }
}
