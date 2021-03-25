package org.example.leetcode;

import org.example.leetcode.java.bean.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author 柳敏
 * @since 2021-03-22 20:27
 */
public class coder {


    public boolean isUnique(String astr) {
        Set<Character> set = new TreeSet<>();
        for (char ch : astr.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }


    /**
     * 02.03
     * 删除中间节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 01.06 字符串压缩
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
        // 空串处理
        if (S.length() == 0) {
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();
    }


    /**
     * 02.02 返回倒数第K个节点：双指针
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        //设置哑节点
        ListNode yummy = new ListNode(0);
        yummy.next = head;
        //初始化快慢指针在哑节点处
        ListNode slow = yummy, fast = yummy;
        //快指针先走k步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //当快指针不为空时，快、慢指针同步向前走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //当快指针为空（指向链表末端即最后一节点的next域）时，慢指针所指节点即为所求
        return slow.val;
    }


    /**
     * 双指针 简单版本
     * 时间复杂度
     * 空间复杂度
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast11(ListNode head, int k) {
        ListNode first = head;
        ListNode second = head;
        //第一个指针先走k步
        while (k-- > 0) {
            first = first.next;
        }
        //然后两个指针在同时前进，知道first节点走到最后
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second.val;
    }


    /**
     * 02.02 返回倒数第K个节点：栈实现
     * 时间复杂度
     * 空间复杂度
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast2(ListNode head, int k) {
        //初始化栈
        Deque<Integer> stack = new LinkedList<>();
        ListNode node = head;
        //遍历链表将沿途节点值入栈
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        //记录第k个出栈的节点值即为所求
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = stack.pop();
        }
        return ans;
    }


    /**
     * 10.01 合并排序数组：粗暴直接解决,性能最差劲，没有利用已经子序列已经排序的优势
     * https://leetcode-cn.com/problems/sorted-merge-lcci/
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i != n; ++i) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
    }


    /**
     * 10.01 双指针
     * 时间复杂度O()
     * 空间复杂度O()
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int[] A, int m, int[] B, int n) {
        int pa = 0;
        int pb = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (pa < m || pb < n) {
            if (pa == m) {
                cur = B[pb++];
            } else if (pb == n) {
                cur = A[pa++];
            } else if (A[pa] < B[pb]) {
                cur = A[pa++];
            } else {
                cur = B[pb++];
            }
            sorted[pa + pb - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            A[i] = sorted[i];
        }
    }

    /**
     * 逆向双指针
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge3(int[] A, int m, int[] B, int n) {
        int pa = m - 1, pb = n - 1;
        int tail = m + n - 1;
        int cur;
        while (pa >= 0 || pb >= 0) {
            if (pa == -1) {
                cur = B[pb--];
            } else if (pb == -1) {
                cur = A[pa--];
            } else if (A[pa] > B[pb]) {
                cur = A[pa--];
            } else {
                cur = B[pb--];
            }
            A[tail--] = cur;
        }
    }


    /**
     * 17.14 最小的K个数
     * https://leetcode-cn.com/problems/smallest-k-lcci/
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {

        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }


    /**
     * 堆
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK2(int[] arr, int k) {
        int[] vec = new int[k];
        // 排除 0 的情况
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }


    /**
     * 17.21 直方图的水量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {

        return 1;
    }


    /**
     * 16.26 计算器
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while (i < cs.length) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            char tmp = cs[i];
            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-') {
                i++;
                while (i < cs.length && cs[i] == ' ') {
                    i++;
                }

            }
            int num = 0;
            while (i < cs.length && Character.isDigit(cs[i])) {
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while (!st.isEmpty()) {
            ans += st.pop();
        }
        return ans;
    }


    /**
     * 17.10 主要元素
     * 要求 时间复杂度为 O(N)，空间复杂度为 O(1)，所以不可以暴力解决
     * <p>
     * 哈希表计数，不好
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerEntry : hashMap.entrySet()) {
            if (integerEntry.getValue() > nums.length / 2) {
                return integerEntry.getKey();
            }
        }
        return -1;
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int temp = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                temp = num;
                count = 1;
            } else {
                if (temp == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        if (count > 0) {
            int n = 0;
            for (int i : nums) {
                if (i == temp) {
                    n++;
                }
            }
            if (n > nums.length / 2) {
                return temp;
            }
        }
        return -1;
    }


}
