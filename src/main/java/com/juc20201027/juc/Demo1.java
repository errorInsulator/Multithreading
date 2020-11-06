package com.juc20201027.juc;

public class Demo1 {

    public Demo1(){
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread()+(i+" ... "));
                if(i==0){
                    Thread.yield();
                }

            }
        });
        thread.start();
    }
    public static void main(String[] args) {

        new Demo1();
        new Demo1();
        new Demo1();

    }
}
