package com.juc20201020.th;

import java.util.concurrent.Callable;

public class ComputeTask implements Callable<Integer> {
    private int index;

    public void process(Integer number){
        int max = 100, min = 1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum % (max - min) + min);
        System.out.println("随机数："+ran3);
        this.index=number+ran3;
    }

    public Integer call() throws Exception {

        return this.index;
    }
}
