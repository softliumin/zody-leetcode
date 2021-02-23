package org.example.demo.juc;

import java.util.concurrent.Semaphore;

/**
 * 复习Semaphore的使用
 * @author zody
 * @since 2020-08-01 14:51
 */
public class SemaphoreDemo {

    /**
     * 测试的思路是：
     * @param args
     */
    public static void main(String[] args) {
        int threadNum = 5;
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < threadNum; i++) {
            try {
                System.out.println("111");
                semaphore.release();
            }catch (Exception e){
                e.printStackTrace();
            }

//            new TaskThread(semaphore).start();
        }
    }

    static class TaskThread extends Thread {
        Semaphore semaphore;

        public TaskThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override public void run() {
            try {
                semaphore.acquire();
                System.out.println(getName() + " 获得");
                Thread.sleep(1000);
                semaphore.release();
                System.out.println(getName() + " 释放 ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
