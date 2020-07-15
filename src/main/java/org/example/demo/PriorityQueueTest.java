package org.example.demo;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 学习PriorityQueue 特性
 * @author zody
 * @since 2020-07-13 18:45
 */
public class PriorityQueueTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
//        PriorityQueue<String> q = new PriorityQueue<>();
//        // 添加3个元素到队列:
//        q.offer("apple");
//        q.offer("pear");
//        q.offer("banana");
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());
//        System.out.println(q.poll());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(100);
        pq.offer(1);
        pq.offer(64);
        pq.offer(88);
        pq.offer(12);



        // 取出最小的一个元素
        System.out.println(pq.poll());

        Object[] hu = pq.toArray();
        System.out.println(hu);
    }

}
