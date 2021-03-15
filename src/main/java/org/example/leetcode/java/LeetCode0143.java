package org.example.leetcode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 重排链表
 * 参考：https://leetcode-cn.com/problems/reorder-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-143-z-4kmk/
 * @author 柳敏
 * @since 2021-03-10 20:20
 */
public class LeetCode0143 {

    public static void main(String[] args) {

    }


    public void reorderList(ListNode143 head) {
        if (head == null) {
            return;
        }
        List<ListNode143> list = new ArrayList<ListNode143>();
        ListNode143 node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }


    public void reorderList2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        ListNode pre = slow;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode headCur = head;
        ListNode headNext = head;
        ListNode tailCur = fast;
        ListNode tailNext = fast;
        while (headCur != slow) {
            headNext = headCur.next;
            headCur.next = tailCur;
            headCur = headNext;
            tailNext = tailCur.next;
            tailCur.next = headCur;
            tailCur = tailNext;
        }
        slow.next = null;
    }

}


class ListNode143 {
    int val;
    ListNode143 next;

    ListNode143() {
    }

    ListNode143(int val) {
        this.val = val;
    }

    ListNode143(int val, ListNode143 next) {
        this.val = val;
        this.next = next;
    }
}
