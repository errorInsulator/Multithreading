package com.juc20201020.th;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThFutureClass {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
// 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();
        // 创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            ComputeTask c = new ComputeTask();
            c.process(i);
            FutureTask<Integer> ft = new FutureTask<Integer>(c);
            taskList.add(ft);
            exec.submit(ft);
        }
        for (FutureTask<Integer> ft : taskList) {
            System.out.println(Thread.currentThread().getId()+":"+ft.get());
        }
        exec.shutdown();
    }
}
