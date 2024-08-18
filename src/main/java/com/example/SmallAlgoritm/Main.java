package com.example.SmallAlgoritm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] target = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        System.out.print("please give me number: ");
        int targetNum = scn.nextInt();
        BinarySearch binarySearch = new BinarySearch();
        int result = binarySearch.binarySearch(target, targetNum);
        System.out.println(result);
    }
}
