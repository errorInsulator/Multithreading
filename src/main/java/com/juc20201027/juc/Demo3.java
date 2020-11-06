package com.juc20201027.juc;

public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{

            System.out.println("1");
            try {
                Thread.sleep(2000000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                return;
//                e.printStackTrace();
            }
            System.out.println("3");

        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("over");
    }
}
