package com.example.Secend_Course;

import java.util.concurrent.locks.ReentrantLock;

public class Thread_Example {
    private static int counter = 0;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public void increment(){
        reentrantLock.lock();
        try{
            counter++;
        }finally {
            reentrantLock.unlock();
        }
    }

    public int getCounter(){
        return counter;
    }


    public static void main(String[] args) {
        Thread_Example threadExample = new Thread_Example();

        Thread t1 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t3= new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });


        Thread t5 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t6 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t7 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t8 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });


        Thread t9 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });

        Thread t10 = new Thread(() -> {
            for(int i = 0;i<1_000_000;i++){
                threadExample.increment();
            }
        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        }catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(threadExample.getCounter());

    }

}
