package com.juc20201029;

public class Demo4 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

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
