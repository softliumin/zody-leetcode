package org.example.leetcode.thread;

import java.util.function.IntConsumer;

/**
 * @author 柳敏 minliu
 * @since 2021-02-26 23:24
 */
public class FizzBuzz {

    private int n;
    private volatile int state = -1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        //只输出3的倍数(不包含15的倍数)
        for (int i = 3; i <= n; i += 3) {
            //15的倍数不处理，交给fizzbuzz()方法处理
            if (i % 15 == 0) {
                continue;
            }
            while (state != 3) {
                Thread.sleep(1);
            }
            printFizz.run();
            //控制权交还给number()方法
            state = -1;
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        //只输出5的倍数(不包含15的倍数)
        for (int i = 5; i <= n; i += 5) {
            //15的倍数不处理，交给fizzbuzz()方法处理
            if (i % 15 == 0) {
                continue;
            }
            while (state != 5) {
                Thread.sleep(1);
            }
            printBuzz.run();
            //控制权交还给number()方法
            state = -1;
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        //只输出15的倍数
        for (int i = 15; i <= n; i += 15) {
            while (state != 15) {
                Thread.sleep(1);
            }
            printFizzBuzz.run();
            //控制权交还给number()方法
            state = -1;
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            while (state != -1) {
                Thread.sleep(1);
            }

            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
            } else {
                if (i % 15 == 0) {
                    //交给fizzbuzz()方法处理
                    state = 15;
                } else if (i % 5 == 0) {
                    //交给buzz()方法处理
                    state = 5;
                } else {
                    //交给fizz()方法处理
                    state = 3;
                }
            }
        }
    }


}
