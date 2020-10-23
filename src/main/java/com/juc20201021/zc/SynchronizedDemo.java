package com.juc20201021.zc;

import org.junit.Test;

/**
 * @author admin
 */
public class SynchronizedDemo {
    static Integer index=0;


    public static void main(String[] args) {
        Thread thread1=new Thread(new Runnable() {
            public void run() {
                synchronized (index){
                    System.out.println(Thread.currentThread().getName()+"线程开启");
                    try {
                        //阻塞线程
                        index.wait();
                        System.out.println(Thread.currentThread().getName()+"停止阻塞");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                    }

                }

            }
        });

        Thread thread2=new Thread(new Runnable() {
            public void run() {
                synchronized (index){
                    System.out.println(Thread.currentThread().getName()+"解锁");
                    try {
                        index.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }




}
