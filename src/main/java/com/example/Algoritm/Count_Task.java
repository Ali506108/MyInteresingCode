package com.example.Algoritm;

public class Count_Task {

    private int count_int = 0;

    public synchronized void increment(){
        count_int++;
    }

    public int getCount_int(){
        return count_int;
    }


    public static void main(String[] args) {
        Count_Task ct1 = new Count_Task();
        Thread t1 = new Thread(() -> {
            for(int i =0; i<=10;i++){
                ct1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i =0; i<=10;i++){
                ct1.increment();
            }
        });


        Thread t3 = new Thread(() -> {
            for(int i =0; i<=10;i++){
                ct1.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for(int i =0; i<=10;i++){
                ct1.increment();
            }
        });




        t1.start();
        t2.start();
        t3.start();
        t4.start();


        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println(ct1.getCount_int());


    }

}
