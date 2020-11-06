package com.juc20201102;

public class Demo1 implements Runnable{
//   static String str ;
   private volatile Boolean falg = true;


    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(falg);
        falg=false;
        System.out.println(falg);
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Thread thread = new Thread(demo1);
        thread.start();


        while (true){
            if(!demo1.getFalg()){
                System.out.println("退出");
                break;
            }
        }
    }

    public Boolean getFalg() {
        return falg;
    }

    public void setFalg(Boolean falg) {
        this.falg = falg;
    }
}
