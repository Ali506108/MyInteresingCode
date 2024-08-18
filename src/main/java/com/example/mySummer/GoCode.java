package com.example.mySummer;

public class GoCode {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {

            for(int i = 0; i< 10; i++){
                System.out.println("Thread name: " + Thread.currentThread().getName() + " i : " + i);
                try{
                    Thread.sleep(1000);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<= 10 ;i++){
                System.out.println("Thread name: " + Thread.currentThread().getName() + " i : " + i);
                try{
                    Thread.sleep(1000);
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
