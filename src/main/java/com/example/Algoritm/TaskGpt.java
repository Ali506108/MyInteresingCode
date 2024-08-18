package com.example.Algoritm;

public class TaskGpt {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            for(int i = 0; i<=10;i++){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };


        Thread t1 = new Thread(r1);

        t1.start();
    }

}
