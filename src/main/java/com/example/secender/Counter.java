package com.example.secender;

public class Counter {
    private static int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        Counter c1 = new Counter();
        Runnable r1 = () -> {
            for(int i = 0; i<= 10;i++){
                c1.increment();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Thread: " + c1.getCount());
    }
}
