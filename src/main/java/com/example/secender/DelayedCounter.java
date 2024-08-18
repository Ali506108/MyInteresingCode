package com.example.secender;

public class DelayedCounter {

    private int count = 0;

    public synchronized void incrementWithDelay(int delay){
        try{
            Thread.sleep(delay);
            count++;
            System.out.println("Задержка: " + count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getCount(){
        return count;
    }

    public static void main(String[] args) {
        DelayedCounter d1 = new DelayedCounter();


        Runnable r1 = () -> {
            for(int i = 0; i<=5;i++){
                d1.incrementWithDelay(500);
            }
        };

        Thread t1 = new Thread(r1);

        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();


        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Stuck : " + d1.getCount());
    }
}
