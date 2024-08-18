package com.example.w3task;

public class MyAlgoritm {

    public static void main(String[] args) {
        int[] arr_2 = {1 , 3 , 5 , 7 , 9 , 10 , 15 , 56 , 76 , 89 ,96};
        int l = 0;
        int r = arr_2.length - 1;

        BynarySeatch(arr_2,l,r);
    }

    public static void BynarySeatch(int[] arr, int l , int r){
        while(l<=r){
            int mid = (l+r)/2;

            if(arr[mid] == mid){
                System.out.println(mid);
            }else if(arr[mid]>mid){
                r=mid-1;
            } else {
                l = mid+1;
            }
        }
    }
}
