package org.example.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 柳敏 minliu@91jkys.com
 * @since 2021-02-26 16:02
 */
public class PrintFooBar {

}

class FooBar {
    private int n;

    CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            if (i % 2 == 0) {
                printFoo.run();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            if (i % 2 != 0) {
                printBar.run();
            }
        }
    }
}
