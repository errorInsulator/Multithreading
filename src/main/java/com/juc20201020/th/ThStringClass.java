package com.juc20201020.th;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * String
 * 多线参数传递+返回值
 */
public class ThStringClass implements Callable<String> {
    private int index;

    public void process(Integer number){
        this.index=number;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThStringClass thStringClass = new ThStringClass();
        thStringClass.process(33);
        FutureTask<String> futureTask = new FutureTask<String>(thStringClass);
//        Thread thread = new Thread(new Runnable() {
//            public void run() {
//                System.out.println("11111");
//            }
//        });
//        thread.start();
//        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
//            public String call() throws Exception {
//                return "hello";
//            }
//        });

        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);
    }

    public String call() throws Exception {
        return "年龄："+this.index;
    }
}
