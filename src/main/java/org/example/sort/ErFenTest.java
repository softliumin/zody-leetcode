package org.example.sort;

/**
 * 二分查找
 *
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-03-03 10:52
 */
public class ErFenTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(find(a, 9));
    }

    public static int find(int[] array, int value) {
        //开始点
        int low = 0;
        //结束点
        int high = array.length - 1;
        //中间值
        int middle;
        while (low <= high) {
            //奇数则为中间，偶数则是扁左的值--呵呵
            middle = (low + high) / 2;
            //找出每次的中间点
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i == middle) {
                    System.out.print("#");
                }
                System.out.print(" ");
            }
            System.out.println();

            //中间值就是目标值
            if (array[middle] == value) {
                return middle;
            }

            //比中间值小，舍去右边数据
            if (value < array[middle]) {
                high = middle - 1;
            }
            //比中间值大，舍去左边数据
            if (value > array[middle]) {
                low = middle + 1;
            }
        }
        return -1;
    }


}
