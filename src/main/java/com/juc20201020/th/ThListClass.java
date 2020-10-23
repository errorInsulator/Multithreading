package com.juc20201020.th;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 集合版本
 * 多线参数传递+返回值
 */
public class ThListClass  implements Callable<List> {

    private String index;

    public void process(String number){
        this.index=number;
    }

    public List<String> call() throws Exception {
        List <String> list = new ArrayList<String>();
        list.add("1a:"+this.index);
        list.add("2b:"+this.index);
        list.add("3c:"+this.index);
        return list;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThListClass thListClass = new ThListClass();
        thListClass.process("我是传入进来的");
        FutureTask<List> futureTask = new FutureTask(thListClass);
        new Thread(futureTask).start();
        List<String> list = futureTask.get();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
