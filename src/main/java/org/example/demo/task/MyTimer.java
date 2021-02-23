/**
 * @(#)Timer.java, 2020/7/28.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package org.example.demo.task;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 柳敏 liumin06@corp.netease.com
 * @since 2020-07-28 20:56
 */
public class MyTimer {

    private static final int cpuNum = Runtime.getRuntime().availableProcessors();

    public static final ScheduledExecutorService CHECK_TASK = Executors.newScheduledThreadPool(cpuNum, new ThreadFactory() {
        private AtomicInteger count = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            int index = count.incrementAndGet();
            return new Thread(r, "check-executor-" + index);
        }
    });

    public static void main(String[] args) {

        MyTimerTask myTask = new MyTimerTask("No 1");
        for (int x=0;x<10;x++){
            Timer timer = new Timer();
            timer.schedule(myTask,2000L, 1000L);
        }
        System.out.println("=====");

//        CHECK_TASK.scheduleWithFixedDelay(
//            () -> {
//                System.out.println(Thread.currentThread().getName()+":run");
//            }, 5, 5, TimeUnit.SECONDS);
    }


}
