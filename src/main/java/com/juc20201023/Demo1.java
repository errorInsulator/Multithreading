package com.juc20201023;

/**
 * 独占锁
 */
public class Demo1 {
   static Object lock = new Object();
    public static void main(String[] args) {

        synchronized (lock){
            try {
                System.out.println("1");
                lock.wait(5000);
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
