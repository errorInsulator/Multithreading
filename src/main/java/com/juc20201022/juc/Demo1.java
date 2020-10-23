package com.juc20201022.juc;

/**
 * 可重入锁（递归锁）
 */
public class Demo1 {
    private static volatile Object rA = new Object();

    public static synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName()+"sendSMS");
        sendEmail();
    }
    public static synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName()+"sendEmail");
    }

    public static void main(String[] args) {

        Thread thread1= new Thread(()->{
            Demo1.sendSMS();
        },"t1");

        Thread thread2= new Thread(()->{
            Demo1.sendSMS();
        },"t2");

        thread1.start();
        thread2.start();
    }
}
