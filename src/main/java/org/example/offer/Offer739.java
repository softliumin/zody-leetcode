package org.example.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 观察温度  动态规划
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-20 17:57
 */
public class Offer739 {


    public static int[] dailyTemperatures(int[] T) {
        final int DAY = T.length;
        int[] dp = new int[DAY];
        //最后一天必定为0
        dp[DAY - 1] = 0;
        for (int i = DAY - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                dp[i] = 1;
            } else {
                int nextI = i + 1 + dp[i + 1];
                while (nextI < DAY && T[i] >= T[nextI] && dp[nextI] > 0) {
                    nextI += dp[nextI];
                }
                if (nextI < DAY && T[i] < T[nextI]) {
                    dp[i] = nextI - i;
                }
            }
        }
        return dp;
    }

    // 单调栈
    public static int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        //存储下标
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || T[stack.getLast()] >= T[i]) stack.addLast(i);
            else {//维持单调不增
                while (!stack.isEmpty() && T[stack.getLast()] < T[i]) {
                    res[stack.getLast()] = i - stack.getLast();
                    stack.removeLast();
                }
                //进栈
                stack.addLast(i);
            }
        }

        return res;
    }


}
