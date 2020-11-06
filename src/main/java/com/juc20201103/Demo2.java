package com.juc20201103;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    int count = 0;
    static AtomicInteger number = new AtomicInteger(0);

    Lock lock = new ReentrantLock();

    public void add() {
        count++;
    }

    public void lockAdd(){
        lock.lock();
        try{
            count++;
        }finally {
            lock.unlock();
        }

    }
    public void atomicAdd() {
        number.incrementAndGet();
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        Demo2 demo2 = new Demo2();
        for (int i = 0; i < 200; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
//                    demo2.atomicAdd();
                    demo2.lockAdd();
                }
            });
            thread.start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(demo2.count);
        System.out.println("耗时：" + (System.currentTimeMillis() - a));
    }

}
