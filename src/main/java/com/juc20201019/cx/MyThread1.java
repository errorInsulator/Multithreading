package com.juc20201019.cx;

public class MyThread1 implements Runnable{
    private int n;

    public void set(int n) {
        this.n = n;
    }

    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println(this.n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 t = new MyThread1();
            t.set(i);
            Thread t1 = new Thread(t);
            t1.start();
        }
    }


}
