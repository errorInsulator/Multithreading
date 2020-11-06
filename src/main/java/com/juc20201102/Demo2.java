package com.juc20201102;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 implements Runnable{
    AtomicInteger count=new AtomicInteger (0);
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        Thread t1 = new Thread(demo2);
        Thread t2 = new Thread(demo2);
        t1.start();
        t2.start();
    }

    @Override
    public   void run() {
        for (int i = 0; i < 5; i++) {
            int i1 = count.incrementAndGet();
            System.out.println(Thread.currentThread().getId()+" : "+(i1));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
