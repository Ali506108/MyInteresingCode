package com.example.Algoritm;

public class First_Task {

    public static void main(String[] args) {

        int[] arr = {5 , 3 , 8 , 9 , 6 , 78};
        System.out.println(getSum(arr));
    }


    public static int getSum(int[] arr){
        int sum = 0;
        for(int i = 0; i<=arr.length; i++){
            sum+=i;
        }
        return sum;
    }
}
