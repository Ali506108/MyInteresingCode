package com.example.secender;

public class Warehouse {

    private int items;
    private final Object lock = new Object();


    public Warehouse(int amount){
        this.items = amount;
    }


    public void addItem(int amount){
        synchronized (lock){
            items+=amount;
            System.out.println("add amount " + amount + " final items: " + items);
        }
    }

    public void removeItem(int amount){
        synchronized (lock){
            items-=amount;
            System.out.println("remove amount " + amount + " final items: " + items);
        }
    }



    public int getItems(){
        return items;
    }


    public static void main(String[] args) {
        Warehouse w = new Warehouse(0);


        Runnable add = () -> {
            for(int i = 0; i<=5;i++){
                w.addItem(i);
            }
        };

        Runnable remove = () -> {
            for(int i = 0; i <=3;i++){
                w.removeItem(i);
            }
        };

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(remove);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Finale item: " + w.getItems());
    }
}
