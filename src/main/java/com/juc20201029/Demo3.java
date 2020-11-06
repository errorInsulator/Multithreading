package com.juc20201029;

public class Demo3 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void print() {
        System.out.println(Thread.currentThread().getName()+"==》print start");
        System.out.println(Thread.currentThread().getName() + " : " + threadLocal.get());
        System.out.println(Thread.currentThread().getName()+"==》print end");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            threadLocal.set("thread1");
            print();
        },"t1");
        Thread thread2 = new Thread(()->{
            threadLocal.set("thread2");
            print();
        },"t2");
        Thread thread3 = new Thread(()->{
            threadLocal.set("thread3");
            print();
        },"t3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
