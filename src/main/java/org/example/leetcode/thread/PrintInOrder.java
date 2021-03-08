package org.example.leetcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 执行方法必须有序（考察线程之间通讯）
 *
 * @author 柳敏 minliu
 * @since 2021-02-26 11:55
 */
public class PrintInOrder {
    public static void main(String[] args) {

    }

    class Foo {

        public Semaphore firstTwoLock = new Semaphore(0);

        public Semaphore twoSecondLock = new Semaphore(0);

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            firstTwoLock.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            firstTwoLock.acquire();
            printSecond.run();
            twoSecondLock.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            twoSecondLock.acquire();
            printThird.run();
        }
    }


    class Foo2 {

        private CountDownLatch second = new CountDownLatch(1);
        private CountDownLatch third = new CountDownLatch(1);

        public Foo2() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            second.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.await();
            printSecond.run();
            third.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.await();
            printThird.run();
        }
    }


    class Foo3 {

        private AtomicBoolean first_two = new AtomicBoolean();
        private AtomicBoolean two_third = new AtomicBoolean();

        public Foo3() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            first_two.set(true);
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (!first_two.get()) {

            }
            printSecond.run();
            two_third.set(true);
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (!two_third.get()) {

            }
            printThird.run();
        }

    }


}


