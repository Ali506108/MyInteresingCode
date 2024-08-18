package com.example.Algoritm;

public class MyTest {
    public static void main(String[] args) {

        Thread t1c = new Thread(() -> {
           for(int i = 0;i<=10;i++){
               System.out.println(i);
               try{
                   Thread.sleep(1000);
               }catch(Exception e){
                   e.printStackTrace();
               }
           }
        });


        t1c.start();
    }
}
