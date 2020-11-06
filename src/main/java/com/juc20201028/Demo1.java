package com.juc20201028;

import java.text.SimpleDateFormat;

public class Demo1 {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (; ; ) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "-" + sdf.format(System.currentTimeMillis()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "守护线程");
        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "-" + sdf.format(System.currentTimeMillis()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "用户线程1");
        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "-" + sdf.format(System.currentTimeMillis()));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "用户线程2");
        thread.setDaemon(true);
        thread.start();
        thread1.start();
        thread2.start();
        System.out.println("over");
    }
}
