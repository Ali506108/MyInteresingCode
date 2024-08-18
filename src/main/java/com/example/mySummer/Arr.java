package com.example.mySummer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Arr {

    public static void main(String[] args) {
        try(Scanner scn = new Scanner(System.in)) {
            System.out.print("Enter the size of array : ");
            int size_of_arr = scn.nextInt();
            List<String> list = new ArrayList<>(size_of_arr);

            for (int i = 0; i < size_of_arr; i++) {
                System.out.print("Enter the name of country : ");
                String name_Country = scn.next();
                list.add(name_Country);
            }

            scn.next();


            Collections.sort(list);
            list.forEach(System.out::println);
            System.out.print("Enter the of country you want to search: ");
            String name_of_country = scn.next();
            int index = binary_Search(list, name_of_country);
            if(index != -1 ){
                System.out.println("Country found at index: " + index);
            }else {
                System.out.println("Country not found");
            }
            scn.close();
        }

    }


    public static int binary_Search(List<String> list, String name_Country) {
        int l = 0 , r =  list.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            int comparison = list.get(mid).compareTo(name_Country);
            if(comparison == 0){
                System.out.println(mid);
                return mid;
            }else if(comparison >0){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
}
