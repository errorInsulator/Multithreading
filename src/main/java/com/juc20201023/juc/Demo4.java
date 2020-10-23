package com.juc20201023.juc;

import com.juc20201022.juc.Demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo4 {

    private static final Lock lock = new ReentrantLock();
    public static  void sendSMS(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"sendSMS");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

        sendEmail();
    }
    public static  void sendEmail(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"sendEmail");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

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
