package com.juc20201019.cx;

public class MyThread extends Thread{
    private int n;

    public void setValue(int n) {
        this.n = n;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread();

            t.setValue(i);
            t.start();
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(1000L);
            System.out.println(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
