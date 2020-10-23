package com.juc20201019.test;

public class R implements Runnable{
    public int value = 0;

    public void process(Integer numbers) {
        this.value = numbers;
    }

    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            R r = new R();
            r.process(i);
            new Thread(r).start();
        }

    }
}
