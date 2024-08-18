package com.example.Algoritm;

public class Car {

    private String name;
    private int age;
    private String color;

    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }



    public void drive(){
        System.out.println("drive");
    }

    public void stop(){
        System.out.println("stop");
    }


    public void turnLeft(){
        System.out.println("turnLeft");
    }
    public void turnRight(){
        System.out.println("turnRight");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
