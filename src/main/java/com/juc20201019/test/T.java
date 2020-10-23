package com.juc20201019.test;

public class T extends Thread {

    public int value = 0;

    public void process(Integer numbers) {
        this.value = numbers;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            T t = new T();
            t.process(i);
            t.start();
        }


    }
}
