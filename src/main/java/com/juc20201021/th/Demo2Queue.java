package com.juc20201021.th;

import java.util.LinkedList;
import java.util.Queue;

public class Demo2Queue {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            queue.offer("a"+i);
        }
        System.out.println(queue);
        System.out.println("之前之后");
        String poll = queue.poll();
        System.out.println(poll);

        System.out.println(queue);
//        queue.remove("a6");
//        System.out.println(queue);

    }
}
