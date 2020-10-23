package com.juc20201020.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author admin
 */
public class ThreadTest implements Callable<List> {

    private Integer index;

    public void setIndex(Integer index){
        this.index=index;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest threadTest = new ThreadTest();
        threadTest.setIndex(10);

        FutureTask<List> futureTask=new FutureTask<List>(threadTest);
        Thread thread = new Thread(futureTask);
        thread.start();
        List list = futureTask.get();
        System.out.println(list);


    }


    public List call() throws Exception {

        List<String> list = new ArrayList<String>();
        for (int i = 0; i <index ; i++) {
            list.add("第"+(i+1)+"次打印");
        }
        return list;
    }
}
