package com.juc20201023;

public class Demo2 {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        Thread t1 = new Thread(() -> {
            System.out.println("t1");
            for (; ; ) {
//                System.out.println("=");
            }

        });

        Thread t2 = new Thread(() -> {
            System.out.println("t21");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t22");
//            mainThread.interrupt();
            System.out.println("t23");

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }


    }
}
