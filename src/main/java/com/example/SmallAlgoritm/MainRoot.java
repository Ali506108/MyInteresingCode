package com.example.SmallAlgoritm;

import com.example.SmallAlgoritm.BinaryTree;

public class MainRoot {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(12);

        if(tree.search(6)){
            System.out.println("integer 6 is found");
        }else{
            System.out.println("integer 6 is not found");
        }

        if(tree.search(13)){
            System.out.println("integer 13 is found");
        }else {
            System.out.println("integer 13 is not found");
        }
    }
}
