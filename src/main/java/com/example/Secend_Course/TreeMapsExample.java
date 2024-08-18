package com.example.Secend_Course;

import java.util.TreeMap;

public class TreeMapsExample {


    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(0, "C");
        treeMap.put(1, "Java");
        treeMap.put(2,"C++");
        treeMap.put(3, "Python");
        treeMap.put(4,"Go");
        treeMap.put(5, "Rust");

        System.out.println(treeMap);


        for(int i = 0; i< treeMap.size(); i++) {
            System.out.println(treeMap.get(i));

            if(treeMap.get(i).equals("Python")) {
                treeMap.remove(i);
            }
        }

        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.ceilingKey(3));
        System.out.println(treeMap.floorKey(3));

        System.out.println(treeMap.subMap(1, 5));
    }
}
