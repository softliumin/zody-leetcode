package org.example;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-23 20:24
 */
public class Code0205 {
    public static void main(String[] args) {

    }

    public ListNode0205 addTwoNumbers(ListNode0205 l1, ListNode0205 l2) {
        ListNode0205 head = new ListNode0205(0);
        ListNode0205 prev = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            //求两个节点相加的值
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;

            //取进位的值
            carry = sum / 10;

            //sum对10求余后放到节点中
            prev.next = new ListNode0205(sum % 10);

            prev = prev.next;
            l1 = l1 != null ? l1.next : l1;

            l2 = l2 != null ? l2.next : l2;
        }
        return head.next;
    }
}


class ListNode0205 {

    int val;

    ListNode0205 next;

    ListNode0205(int x) {
        val = x;
    }
}
