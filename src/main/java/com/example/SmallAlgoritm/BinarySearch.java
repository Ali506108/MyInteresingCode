package com.example.SmallAlgoritm;

public class BinarySearch {

    public static int binarySearch(int[] arr, int targer) {
        int left = 0 , right = arr.length - 1;

        while(left<=right) {
            int middle = left +(right-left)/2;

            int guess = arr[middle];

            if(guess == targer) {
                return middle;
            }else if(guess > targer) {
                right = middle - 1;
            }else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
