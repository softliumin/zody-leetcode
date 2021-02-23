package org.example.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-22 14:39
 */
public class Test002 {

    public static void main(String[] args) throws Exception {
        // 复习CountDownLatch的用法和底层实现
        CountDownLatch countDownLatch = new CountDownLatch(5);

        new Thread(new MyThread(countDownLatch)).start();
        new Thread(new MyThread(countDownLatch)).start();
        new Thread(new MyThread(countDownLatch)).start();
        new Thread(new MyThread(countDownLatch)).start();
        new Thread(new MyThread(countDownLatch)).start();

        countDownLatch.await();
        System.out.println("2222");

    }
}

class MyThread implements Runnable {

    CountDownLatch cd;

    MyThread(CountDownLatch countDownLatch) {
        cd = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("1111");
        cd.countDown();
    }
}


class MyThread2 implements Callable<String> {


    public static void main(String[] args) {
        MyThread2 ctt = new MyThread2();
        FutureTask<Integer> ft = new FutureTask(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值" + i);
            if (i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值：" + ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String call() throws Exception {
        return null;
    }
}



