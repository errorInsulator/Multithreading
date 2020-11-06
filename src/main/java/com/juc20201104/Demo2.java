package com.juc20201104;

import java.util.concurrent.atomic.AtomicReference;

public class Demo2 {

    public static void main(String[] args) {
        AtomicReference<User> reference = new AtomicReference();
        User user = new User(20,"用户1");
        reference.set(user);


        User user2 = new User(25,"用户27");

        System.out.println(reference.compareAndSet(user,user2)+"===>"+reference.get().id+":"+reference.get().name);

        User user3 = new User(25,"用户27");

        User user4 = new User(29,"用户30");
        System.out.println(reference.compareAndSet(user2,user4)+"===>"+reference.get().id+":"+reference.get().name);

    }

    public static class User{
        private Integer id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }



    }
}
