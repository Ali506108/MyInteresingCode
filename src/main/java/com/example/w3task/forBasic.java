package com.example.w3task;

public class forBasic extends Thread {

    @Override
    public void run() {
        for(int i = 0;i <= 10 ; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        forBasic f1 = new forBasic();
        f1.start();
    }
}
