package com.example.w3task;

public class Basic extends Thread{
    @Override
    public void run(){
        System.out.println("Hello  world");
    }
    public static void main(String[] args) {
        Basic b = new Basic();
        b.start();
    }
}
