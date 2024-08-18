package com.example.Algoritm;

import java.util.Scanner;

public class BinarySearch {

    protected static int binarySearch(int[] arr , int target){
        int left = 0 , right = arr.length -1;

        while(left<=right){
            int middle = (left+right)/2;

            if(arr[middle] == target){
                return middle;
            }

            if(arr[middle] < target){
                left=middle+1;
            }

            if(arr[middle] > target){
                right=middle-1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        System.out.print("please give me number: ");
        int target = scn.nextInt();
        System.out.print("please type me length: ");
        int length = scn.nextInt();
        int[] arr = new int[length];


        for(int i =0;i< length;i++){
            System.out.print("please type you're num: ");
            int number = scn.nextInt();
            arr[i] =number;
        }

        int result = binarySearch(arr,target);

        if(result == -1){
            System.out.println("Error");
        }else{
            System.out.println(result);
        }
    }


}
