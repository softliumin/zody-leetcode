package org.example.demo;

/**
 * 各种基本排序实现
 * @author zody
 * @since 2020-07-11 10:28
 */
public class SortTest {

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 3, 8, 1, 5 };
        int[] result = bubbleSort(nums);
        System.out.println(result);
    }

    /**
     * 冒泡排序
     * 时间复杂度
     * 空间复杂度
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        if (null == nums || nums.length == 0) {
            return nums;
        }
        int temp;
        for (int x = 0; x < nums.length; x++) {
            // 是否发生交换。没有交换，提前跳出外层循环
            boolean flag = false;
            for (int y = 0; y < nums.length - 1 - x; y++) {
                if (nums[y] > nums[y + 1]) {
                    temp = nums[y];
                    nums[y] = nums[y + 1];
                    nums[y + 1] = temp;
                    flag = true;
                }
            }
            // 节省无意义的循环
            if (!flag) {
                break;
            }
        }
        return nums;
    }

    /**
     * 快速排序
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums) {

        return null;
    }

    /**
     * 堆排序
     * @param nums
     * @return
     */
    public static int[] heapSort(int[] nums) {

        return null;
    }

    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] insertionSort(int[] nums) {

        return null;
    }

    /**
     * 归并排序
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {

        return null;
    }

    /**
     * 选择排序
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums) {

        return null;
    }

    /**
     * 希尔排序
     * @param nums
     * @return
     */
    public static int[] shellsort(int[] nums) {

        return null;
    }

}
