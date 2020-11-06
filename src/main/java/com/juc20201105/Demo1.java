package com.juc20201105;

import com.juc20201104.Demo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Demo1 {
    static AtomicInteger reference = new AtomicInteger(2020);
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===================ABA的产生====================");

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "初始 : " + reference.get());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean set = reference.compareAndSet(2020, 1010);
            System.out.println(set + " : " + reference.get());

//            set = reference.compareAndSet(2021, 2020);
//            System.out.println(set + " : " + reference.get());
        }, "t1");

        Thread t2 = new Thread(() -> {
          int a=  reference.get();
            System.out.println(Thread.currentThread().getName() + "初始 : " + a);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean set = reference.compareAndSet(2020, 1010);
            System.out.println(set + " : " + reference.get());
        }, "t2");


        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("=============ABA的解决=============");
//
//        AtomicStampedReference reference1 = new AtomicStampedReference(100,0);
//
//        Thread t3 = new Thread(() -> {
//            int expectedStamp =reference1.getStamp();
//            System.out.println(Thread.currentThread().getName()+",-1,当前版本:"+reference1.getStamp()+",当前值:"+reference1.getReference());
//            reference1.compareAndSet(100,101,expectedStamp,reference1.getStamp()+1);
//            System.out.println(Thread.currentThread().getName()+",-2,当前版本:"+reference1.getStamp()+",当前值:"+reference1.getReference());
//            reference1.compareAndSet(101,100,reference1.getStamp(),reference1.getStamp()+1);
//            System.out.println(Thread.currentThread().getName()+",-3,当前版本:"+reference1.getStamp()+",当前值:"+reference1.getReference());
//        }, "t3");
//
//
//        Thread t4 = new Thread(() -> {
//
//            int expectedStamp =reference1.getStamp();
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+",-1,当前版本:"+reference1.getStamp()+",当前值:"+reference1.getReference());
//            reference1.compareAndSet(100,31,expectedStamp,reference1.getStamp()+1);
//            System.out.println(Thread.currentThread().getName()+",-2,当前版本:"+reference1.getStamp()+",当前值:"+reference1.getReference());
//        }, "t4");
//
//        t3.start();
//        t4.start();

    }
}
