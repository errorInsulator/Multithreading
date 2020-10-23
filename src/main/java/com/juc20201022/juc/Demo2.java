package com.juc20201022.juc;

public class Demo2 {
    private static volatile Object rA = new Object();
    private static volatile Object rB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                synchronized (rA) {
                    System.out.println(Thread.currentThread().getName() + "RA");
                    synchronized (rB) {
                        System.out.println(Thread.currentThread().getName() + "RB1");
                        rA.wait();
                        System.out.println(Thread.currentThread().getName() + "RB2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread thread2 = new Thread(() -> {
            try {
                synchronized (rA) {
                    System.out.println(Thread.currentThread().getName() + "RA");
                    synchronized (rB) {
                        System.out.println(Thread.currentThread().getName() + "RB1");
//                        rA.wait();
                        System.out.println(Thread.currentThread().getName() + "RB2");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2");

        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }
}
