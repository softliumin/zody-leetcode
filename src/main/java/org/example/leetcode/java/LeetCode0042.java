package org.example.leetcode.java;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * 困难
 *
 * @author 柳敏
 * @since 2021-03-24 10:09
 */
public class LeetCode0042 {

    public static void main(String[] args) {

    }

    // 暴力（按列计算）
    // 时间复杂度： O(n^2)
    // 空间复杂度 O(1)
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            //Search the left part for max bar size
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            //Search the right part for max bar size
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    // 按行计算 TODO

    // 动态规划 时间复杂度： O(n) 空间复杂度 O(n)


    // 双指针 时间复杂度： O(n) 空间复杂度 O(1)

    // 单调栈


    /**
     * 排名第一结果
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {

        // 分析可以看到，住满水之后，呈山峰状
        // 左起到最高点单调递增
        // 从最高点到最右单调递减
        // 用最高点将数组分为两部分，分别注水

        int sum = 0;
        int indexForMaxNumber = 0;

        if (height.length < 3) {
            return 0;
        }

        // 找到最高点
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[indexForMaxNumber]) {
                indexForMaxNumber = i;
            }
        }
        // 左侧注水，由于住满水之后左侧是一个上升的台阶
        // 如果height[i]小于当前的台阶，则注水
        // 注水之后与台阶齐平
        // 如果height[i]大于当前的台阶，上一新台阶
        int tempHigh = height[0];
        for (int i = 1; i < indexForMaxNumber; i++) {
            if (height[i] > tempHigh) {
                tempHigh = height[i];
            } else {
                sum += tempHigh - height[i];
            }
        }

        // 右侧注水，右侧是一个下降台阶
        // 从队尾向前，又变成一个上升台阶，可参照左侧注水
        tempHigh = height[height.length - 1];
        for (int i = height.length - 1; i > indexForMaxNumber; i--) {
            if (height[i] > tempHigh) {
                tempHigh = height[i];
            } else {
                sum += tempHigh - height[i];
            }
        }
        return sum;
    }


    // 通俗易懂（把最大值位置找到，再乘数组长度，求出长方形面积，然后把空白和黑色区域减掉，就是雨水的面积，这样也可以）
    public int trap3(int[] height) {
        if (height.length <= 1){
            return 0;
        }
        int max = height[0];
        int maxIndex = 0;

        // 黑色区域，柱子占据区域
        int blackVolume = 0;
        for (int i = 0 ; i < height.length ; i++ ){
            blackVolume += height[i];
            if (height[i] > max){
                max = height[i];
                maxIndex = i;
            }
        }
        int volume = 0;

        // 求空白区域
        int leftValue = height[0];
        for (int left = 0 ; left <= maxIndex ; left++ ){
            if (leftValue < height[left]){
                volume += left * ( height[left] - leftValue);
                leftValue = height[left];
            }
        }
        int rightValue = height[height.length - 1];
        for (int right = height.length - 1 ; right >= maxIndex ; right-- ){
            if (height[right] > rightValue){
                volume += ( height.length - right  - 1) * ( height[right] - rightValue );
                rightValue = height[right];
            }
        }
        return max * height.length - blackVolume - volume;
    }
}
