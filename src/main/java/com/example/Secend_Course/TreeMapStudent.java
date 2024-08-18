package com.example.Secend_Course;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapStudent {

    private TreeMap<String ,  Integer[]> treeMap = new TreeMap<>();

    protected void addStudent(String name, Integer[] marks) {
        treeMap.put(name, marks);
    }
    protected void removeStudent(String name) {
        treeMap.remove(name);
        if(!treeMap.containsKey(name)) System.out.println("Student not found");
        else System.out.println("Student removed successfully");
    }

    protected Integer[] getStudentMarks(String name) {
        return treeMap.get(name);
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        TreeMapStudent  treeMapStudent = new TreeMapStudent();
        while(true){
            System.out.println("1. Add Student\n2. Remove Student\n3. Get Student Marks\n4. Exit");
            int choice = scn.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter Student Name: ");
                    String name = scn.next();
                    System.out.println("Enter Marks: ");
                    Integer[] marks = new Integer[3];
                    for(int i = 0; i < 3; i++){
                        marks[i] = scn.nextInt();
                    }
                    treeMapStudent.addStudent(name, marks);
                case 2:
                    System.out.println("Enter Student Name: ");
                    name = scn.next();
                    treeMapStudent.removeStudent(name);
                case 3 :
         System.out.println("Enter Student Name: ");
                    name = scn.next();
                    System.out.println(Arrays.toString(treeMapStudent.getStudentMarks(name)));
                case 4:
                    System.exit(0);
            }
        }
    }
}
