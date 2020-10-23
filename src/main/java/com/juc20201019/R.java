package com.juc20201019;

public class R implements Runnable{
    private int index;

    private void process(Integer number){
        this.index=number;
    }


    public void run() {
        try {
            Thread.sleep(1000);
//            System.out.println(this.index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            R r = new R();
            r.process(i);
            Thread thread = new Thread(r);
            thread.start();
        }

    }

}
