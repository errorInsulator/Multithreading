package com.juc20201019;

public class T extends Thread{

    private int index;

    public void process(Integer number){
        this.index=number;
    }



    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(this.index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            T t = new T();
            t.process(i);
            t.start();
        }


    }
}
