package org.example.bytedance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author 柳敏 minliu
 * @since 2021-02-24 19:57
 */
public class test001 {
    public static void main(String[] args) {
        int[] temp = {4, 1, -1, 2, -1, 2, 3};
        int[] result = topKFrequent(temp, 2);
        for (int x = 0; x < result.length; x++) {
            System.out.println(result[x]);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(list);
//        list.forEach(obj -> priorityQueue.add(obj));
        for (int x = 0; x < k; x++) {
            result[x] = priorityQueue.poll();
        }
        return result;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
