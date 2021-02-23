package org.example.demo.task;

import java.util.TimerTask;

/**
 * @author zody
 * @since 2020-07-28 20:58
 */
public class MyTimerTask extends TimerTask {

    private String name;

    public MyTimerTask(String inputName) {
        name = inputName;
    }

    @Override public void run() {
        System.out.println(Thread.currentThread().getName() + ":run");
    }
}
