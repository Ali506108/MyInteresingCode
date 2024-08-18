package com.example.Secend_Course;


class Runnable_Example implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable Example runing " + Thread.currentThread().getName());
        for(int i = 0; i< 100;i++){
            System.out.println(i + " " +Thread.currentThread().getName());
        }
    }
}


public class MyScript {
    public static void main(String[] args) {
        Runnable_Example runnable_example = new Runnable_Example();
        runnable_example.run();
    }
}
