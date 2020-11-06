package com.juc20201027.juc;

public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{

            while (!Thread.currentThread().isInterrupted()){
                System.out.println("启动中");
            }

        });
        thread.start();
        Thread.sleep(1000);
//        System.out.println("是否被中断：");
//        System.out.println(thread.isInterrupted());
        thread.interrupt();
//        System.out.println("是否被中断：");
//        System.out.println(thread.isInterrupted());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }
}
