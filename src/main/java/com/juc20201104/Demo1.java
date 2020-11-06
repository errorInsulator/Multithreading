package com.juc20201104;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo1 {
    public static void main(String[] args) {
        AtomicInteger index = new AtomicInteger();
        index.set(123);

        int a = 123;
        System.out.println(index.compareAndSet(a, 124));
        System.out.println("1交换之后："+index.get());

        System.out.println(index.compareAndSet(a, 124));

        System.out.println("2交换之后："+index.get());

    }
}
