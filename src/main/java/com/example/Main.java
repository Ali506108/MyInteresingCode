package com.example;

public class Main {
    public static void main(String[] args) {

        Runnable r1 = () -> {
            for(int i = 0; i< 10; i++){
                System.out.println("Runnble method: " + i);
            }
        };

        Runnable r2 = () -> {
            for(int i = 0 ; i<10;i++){
                System.out.println("Secend thread " + i);
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t2.start();
        t1.start();
    }
}