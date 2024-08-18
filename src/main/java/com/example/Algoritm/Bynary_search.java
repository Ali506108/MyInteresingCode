package com.example.Algoritm;

public class Bynary_search {

    public static void main(String[] args) {
        int[] arr_Test = {1 , 78 , 5 , 7 , 9 , 10 , 15 , 56 , 76 , 89 ,};
        int  l =0 ;
        int r = arr_Test.length - 1;

        Search_output(arr_Test , l , r);
    }


    protected static void Search_output(int[] arr , int l , int r){
        while(l <= r){
            int mid = (l + r)/2;

            if(arr[mid] == mid){
                System.out.println(mid);
                break;
            }else if(arr[mid] > mid){
                r= mid -1;
            }else{
                l = mid +1;
            }
        }
    }
}
