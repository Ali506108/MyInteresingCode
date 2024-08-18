package com.example.Secend_Course;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MultPractice {

    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("Java");
        treeSet.add("C++");
        treeSet.add("Python");
        treeSet.add("C#");
        treeSet.add("Go");
        treeSet.add("Rust");

        String check = "Java";

        System.out.println("Check: " + check + " is treeSet " + treeSet.contains(check));


        System.out.println(treeSet);

        Set<Integer> treeSet_Int = new TreeSet<>();
        treeSet_Int.add(5);
        treeSet_Int.add(78);
        treeSet_Int.add(1);
        treeSet_Int.add(0);
        treeSet_Int.add(96);

        System.out.println(treeSet_Int);


        NavigableSet<String> programing_language = new TreeSet<>();

        programing_language.add("C");
        programing_language.add("Java");
        programing_language.add("C++");
        programing_language.add("Python");
        programing_language.add("C#");
        programing_language.add("Go");
        programing_language.add("Rust");


        System.out.println(programing_language);
        System.out.println("Count Java : " + programing_language.contains("Java"));
        System.out.println("First : " + programing_language.first());
        System.out.println("last " + programing_language.last());
        System.out.println("Higher " + programing_language.higher("Java"));
        System.out.println("Lower " + programing_language.lower("Java"));





        for(String value: programing_language){

        }
    }
}
