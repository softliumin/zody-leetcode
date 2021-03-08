package org.example.sort;

/**
 * 快排 核心:递归 分置
 *
 * @author 柳敏 minliu
 * @since 2021-03-03 10:36
 */
public class QuickTest {
    public static void main(String[] args) {
        int[] ss = {46, 2, 22, 7, 2, 34, 6, 8, 99, 33};
        quickSort(ss);
        System.out.println(ss[5]);
    }


    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    // 递归调用
    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            //将数组分为两部分
            int pivot = partition(arr, low, high);
            //递归排序左子数组
            qsort(arr, low, pivot - 1);
            //递归排序右子数组
            qsort(arr, pivot + 1, high);
        }
    }

    //把数据分为两部分(对象  两个元素的起始许下标)

    private static int partition(int[] arr, int low, int high) {
        //枢轴记录，直接取第一个元素
        int pivot = arr[low];
        while (low < high) {

            while (low < high && arr[high] >= pivot) {
                --high;
            }

            //交换比枢轴小的记录到左端
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                ++low;
            }
            //交换比枢轴小的记录到右端
            arr[high] = arr[low];
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;


        // 打印效果
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println("");

        //返回的是枢轴的位置
        return low;
    }

    // 新版本（一样的思路）
    public static void quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    public static void quickSort2(int[] arr, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end) {
            return;
        }
        // 将数组分区，并获得中间值的下标
        int middle = partition2(arr, start, end);
        // 对左边区域快速排序
        quickSort2(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort2(arr, middle + 1, end);
    }

    // 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
    public static int partition2(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                exchange(arr, left, right);
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) {
            right--;
        }
        // 将基数和中间数交换
        if (right != start) {
            exchange(arr, start, right);
        }
        // 返回中间值的下标
        return right;
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 不用中间值，交换值
     *
     * @param numbers
     * @return
     */
    public static int[] swapNumbers(int[] numbers) {
        numbers[1] = numbers[1] + numbers[0];
        numbers[0] = numbers[1] - numbers[0];
        numbers[1] = numbers[1] - numbers[0];
        return numbers;
    }

    public int[] swapNumbers3(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }


}
