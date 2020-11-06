package com.juc20201029.zc;

import java.net.BindException;

/**
 * @author admin
 */
public class Demo1 {
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();

    private static Integer index=1;
    public static void main(String[] args) {
        threadLocal.set(index);

        Thread thread1= new Thread(()->{
            index++;
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        });

        Thread thread2= new Thread(()->{
            index++;
            threadLocal.set(index);
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        });

        Thread thread3= new Thread(()->{
            index++;
            threadLocal.set(index);
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        });
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
    }

}
