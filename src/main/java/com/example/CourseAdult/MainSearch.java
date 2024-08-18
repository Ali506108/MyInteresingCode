package com.example.CourseAdult;
import com.example.CourseAdult.BinaryTrees;

import java.util.Scanner;

public class MainSearch {

    public static void main(String[] args) {

        Scanner scn =new Scanner(System.in);
        BinaryTrees tree = new BinaryTrees();


        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.printTree();

        System.out.print("Write a number: ");
        int value = scn.nextInt();
        System.out.println(tree.search(value));
    }


}
