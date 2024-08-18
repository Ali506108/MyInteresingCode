package com.example.Algoritm;

public class Secend_Task {

    public static void main(String[] args) {
        System.out.println(getPalindrome("APA"));
    }

    public static boolean getPalindrome(String text){
        int left = 0 , right = text.length() - 1;

        while(left<right){
            if(text.charAt(left) != text.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
