package com.juc20201021.th;

/**
 * wait线程阻塞挂起
 * notify，notifyAll线程唤醒
 */
public class Demo1 {
    static Integer index = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (index) {
                    try {
                        System.out.println("wait1==");
                        while (index != 12){
                            index.wait();
                            System.out.println("while==");
                        }
                        System.out.println("wait2==");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (index) {
                    System.out.println("notify1==");
                    index.notifyAll();
                    System.out.println("notify2==");
                }
            }
        });
        thread1.start();
        index=12;
        thread2.start();
    }
}
