package com.juc20201029;

public class Demo1 {
    static String str = null;

    public static void print() {
        System.out.println(Thread.currentThread().getName() + " : " + str);
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
//            str="thread1";
            print();
        }, "t1");

        Thread thread2 = new Thread(() -> {
            str="thread2";
            print();
        }, "t2");

        Thread thread3 = new Thread(() -> {
            str="thread3";
            print();
        }, "t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
