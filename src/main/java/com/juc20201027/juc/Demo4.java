package com.juc20201027.juc;

import com.juc20201019.test.T;

public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{


            for (; ; ) {
//                System.out.println("1");
            }

        });
        thread.start();
        System.out.println("之前isInterrupted:"+thread.isInterrupted());
        Thread.sleep(1000);
        thread.interrupt();

        System.out.println("之后isInterrupted:"+thread.isInterrupted());

       //获取中断重置
        System.out.println("Thread.interrupted:"+ Thread.interrupted());

        System.out.println("isInterrupted:"+thread.isInterrupted());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
