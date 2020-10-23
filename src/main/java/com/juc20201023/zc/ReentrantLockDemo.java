package com.juc20201023.zc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 */
public class ReentrantLockDemo {
    static Lock lock=new ReentrantLock();

    public static void main(String[] args) {
       Thread thread1 = new Thread(()->{
            System.out.println("当前执行的线程是："+Thread.currentThread().getName());
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"拿到锁了");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放锁了");
            }
        },"t1");

        Thread thread2 = new Thread(()->{
            System.out.println("当前执行的线程是："+Thread.currentThread().getName());
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"拿到锁了");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName()+"释放锁了");
            }
        },"t2");

        thread1.start();
        thread2.start();

    }
}
