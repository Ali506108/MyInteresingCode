package com.example.stepik;

public class xampleTask {
    public static void main(String[] args) {
        Thread t1= new Thread(() -> {
            for(int i = 0; i<10;i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i<=25;i++){
                System.out.println(i);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
