package com.example.secender;

public class BlockSynchronizedCounter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock){
            count++;
        }
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        BlockSynchronizedCounter c1 = new BlockSynchronizedCounter();
        Runnable r1 = () -> {
            for(int i = 0 ; i<= 1000;i++){
                c1.increment();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        Thread t3 = new Thread(r1);

        t1.start();
        t2.start();
        t3.start();



        try{
            t1.join();
            t2.join();
            t3.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Final count: " + c1.getCount());
    }
}
