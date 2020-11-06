package com.juc20201029;

public class Demo2 {
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        String s = threadLocal.get();
        System.out.println(s);
        threadLocal.set("123");
        threadLocal.set("1234");
        s = threadLocal.get();
        System.out.println(s);
        threadLocal.remove();
        s = threadLocal.get();
        System.out.println(s);
    }
}
