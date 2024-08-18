package com.example.secender;

public class WebSocket {

    private static double webComing;
    private final Object lock = new Object();




    public void increment(){
        synchronized (lock){
            webComing++;
        }
    }

    public double getWebComing(){
        return webComing;
    }

    public static void main(String[] args) {
        WebSocket w1 = new WebSocket();


        Runnable visit = () -> {
            for(int i = 0 ; i<=10;i++){
                w1.increment();
            }
        };


        Thread t1  = new Thread(visit);
        Thread t2  = new Thread(visit);
        Thread t3  = new Thread(visit);
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

        System.out.println(w1.getWebComing());
    }
}
