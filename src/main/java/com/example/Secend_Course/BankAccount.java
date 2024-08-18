package com.example.Secend_Course;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance;
    private Lock lock = new ReentrantLock();

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount c1 = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c1.deposit(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i <= 850; i++) {
                c1.deposit(i);
            }
        });

        Thread r2 = new Thread(() -> {
            for (int t = 0; t < 320; t++) {
                c1.withdraw(t);
            }
        });

        t1.start();
        t2.start();
        r2.start();

        try {
            t1.join();
            t2.join();
            r2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(c1.getBalance());
    }
}
