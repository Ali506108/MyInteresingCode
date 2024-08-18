package com.example.Algoritm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Execute_Task {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i = 0; i<= 10; i++){
            final int taskId = i;
            executor.execute(() -> {
                int exeTime = ThreadLocalRandom.current().nextInt(1000 , 4001);

                System.out.println("Task " + taskId + " started, will run for " + (exeTime / 1000)  + " second");
                try{
                    Thread.sleep(exeTime);
                }catch(Exception e){
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();

        try{
            if(!executor.awaitTermination(60 , TimeUnit.SECONDS)){
                executor.shutdown();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
