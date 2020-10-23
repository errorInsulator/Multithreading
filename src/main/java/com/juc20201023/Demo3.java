package com.juc20201023;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 手动，独占锁：只能一个线程只能读写
 * 共享锁：多个线程可读，不能改
 */
public class Demo3 {

    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) throws Exception {

        Thread thread1 = new Thread(()->{
            System.out.println("执行的线程1："+Thread.currentThread().getName());
            lock.lock();
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("释放1"+Thread.currentThread().getName());
            }
        },"t1");

        Thread thread2 = new Thread(()->{
            System.out.println("执行的线程2："+Thread.currentThread().getName());
            lock.lock();
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
                System.out.println("释放2"+Thread.currentThread().getName());
            }
        },"t2");

        thread1.start();
        thread2.start();
    }
}
