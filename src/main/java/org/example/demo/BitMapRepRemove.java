package org.example.demo;

import java.util.Arrays;

/**
 * @author zody
 * @since 2020-07-21 20:27
 */
public class BitMapRepRemove {
    //public static final int _1MB = 1024 * 1024;

    //public static byte[] flags = new byte[ 512 * _1MB ];

    public static byte[] flags;

    public static void main(String[] args) {

        int[] array = { 255, 1024, 1024, 0, 65536, 0, 1024, 8888, 9999, 1111, 8888 };

        int length = 65536 + 1;
        flags = new byte[(int) (length >> 3) + ((length & 7) > 0 ? 1 : 0)];

        int index = 0;
        for (int num : array) {
            if (getFlags(num) != 1) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                setFlags(num);
            }
        }
        array = Arrays.copyOf(array, index);
        System.out.println(Arrays.toString(array));
        System.out.println(array.length);
    }

    public static void setFlags(int num) {
        int offset = num & (0x07);
        flags[num >> 3] |= 0x01 << offset;
    }

    public static int getFlags(int num) {
        int offset = num & (0x07);
        return flags[num >> 3] >> offset & 0x01;
    }
}
