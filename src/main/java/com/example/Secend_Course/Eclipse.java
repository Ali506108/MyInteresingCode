package com.example.Secend_Course;

public class Eclipse {
    private static int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }


    public static void main(String[] args) {
        Eclipse eclipse = new Eclipse();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i< 1000; i++) {
                eclipse.increment();
            }
        });
        Thread t2 = new Thread(() ->{
           for (int i = 0; i< 250;i++){
               eclipse.decrement();
           }
        });

        Thread t3 = new Thread(() -> {
            for(int i = 0; i< 1500;i++) {
                eclipse.increment();
            }
        });

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(eclipse.getCount());
    }
}
