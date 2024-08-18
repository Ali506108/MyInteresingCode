package com.example.Secend_Course;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewCase {

    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        NewCase newCase = new NewCase();

        Thread t1 = new Thread(() -> {
            for(int i =0;i<=1500;i++) {
                newCase.increment();
            }
        });

        t1.start();

        try{
            t1.join();
        }catch (Exception e ) {
            e.printStackTrace();
        }
        System.out.println(newCase.getCounter());
    }
}
