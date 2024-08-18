package com.example.w3task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private double balance;
    private Lock lock;


    public BankAccount(){
        balance = 0.0;
        lock = new ReentrantLock();
    }

    public void deposit(double amount){
        lock.lock();
        try{
            balance+=amount;
            System.out.println("Deposited : " + amount);
            System.out.println("Deposit balance : "  + balance);
        }finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount){
        lock.lock();
        try{
            if(balance>= amount){
                balance-=amount;
                System.out.println("Withdraw: " + amount);
                System.out.println("Balance after withdraw: " + balance);
            }else{
                System.out.println("Try to withdraw : " + amount);
                System.out.println("Error");
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount();


        Thread t1 = new Thread(() -> account.deposit(1000));
        Thread t2 = new Thread(() -> account.deposit(1500));
        Thread w1t1 = new Thread(() -> account.withdraw(500));
        Thread w2t2 = new Thread(() -> account.withdraw(150));

        t1.start();
        t2.start();
        w1t1.start();
        w2t2.start();

    }
}
