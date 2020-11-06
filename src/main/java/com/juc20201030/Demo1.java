package com.juc20201030;

public class Demo1 {
    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("1234");

        Thread thread1 = new Thread(()->{
            String str=  threadLocal.get();
            System.out.println(Thread.currentThread().getName()+": "+str);
        },"t1");
        thread1.start();

        System.out.println(Thread.currentThread().getName()+": "+threadLocal.get());
    }
}
