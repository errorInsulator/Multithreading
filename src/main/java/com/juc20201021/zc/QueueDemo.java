package com.juc20201021.zc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin
 */
public class QueueDemo {


    public static void main(String[] args) {
        Queue<String> queue=new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            queue.offer("元素"+i);
        }
        System.out.println("操作前的队列");
        System.out.println(queue);

//        //移除一个元素
//        queue.remove();
//        //元素先进先出 所有最先出来的元素应该是0
//        System.out.println("移除一个元素后的队列");
//        System.out.println(queue);

        //peek一个元素  不移除元素，但是remove和poll都会移除元素
        String peek = queue.peek();
        System.out.println(peek);
        System.out.println("peek后的队列");
        System.out.println(queue);



    }

}
