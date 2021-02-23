package org.example.demo;

import java.io.File;

/**
 * @author zody
 * @since 2020-08-01 11:08
 */
public class RecursionDemo {

    /**
     * 递归显示文件夹
     * @param args
     */
    public static void main(String[] args) {
        traverseFolder("/Users/zody/tools/学习视频");
    }

    /**
     * 没去检查文件是否存在和是否时空
     * @param path
     */
    public static void traverseFolder(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File file2 : files) {
            if (file2.isDirectory()) {
                System.out.println("文件夹:" + file2.getAbsolutePath());
                traverseFolder(file2.getAbsolutePath());
            } else {
                System.out.println("文件:" + file2.getAbsolutePath());
            }
        }

    }
}
