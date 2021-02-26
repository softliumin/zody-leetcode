package org.example.bytedance;

/**
 * 两个线程交替打印奇偶数
 *
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-24 17:12
 */
public class SwitchThread {

    public static int count;


    public static void main(String[] args) {

        Object object = new Object();

        // 版本1交替打印
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if ((count & 1) == 0) {
                            System.out.println("奇数");
                            count++;
                        }
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (object) {
                        if ((count & 1) == 1) {
                            System.out.println("偶数");
                            count++;
                        }
                    }
                }
            }
        });

//        t1.start();
//        t2.start();
        String a = "a";
        ThreadPrint tt1 = new ThreadPrint(a);
        ThreadPrint tt2 = new ThreadPrint(a);
        new Thread(tt1, "线程1").start();
        new Thread(tt2, "线程2").start();

    }
}


class ThreadPrint implements Runnable {

    private static int i = 1;


    private String s1;

    ThreadPrint(String s) {
        s1 = s;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (s1) {
                Thread t1 = Thread.currentThread();
                System.out.println(t1.getName() + ":" + (i++));
                //设置中断数字
                if (i > 101) {
                    s1.notify();
                    break;
                }
                s1.notify();
                try {
                    s1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
