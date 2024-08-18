package com.example.SmallAlgoritm;

public class BinaryTree {

    Node root;

    BinaryTree(){
        root = null;
    }


    void insert(int value) {
        root = insertRec(root, value);
    }


    Node insertRec(Node root , int value) {
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(value  <= root.value) {
            root.left = insertRec(root.left, value);
        }else if(value >= root.value){
            root.right = insertRec(root.right, value);
        }


        return root;
    }

    boolean search(int value) {
        return searchRec(root, value);
    }

    boolean searchRec(Node root, int value) {
        if(root == null) {
            return false;
        }
        if(root.value == value) {
            return true;
        }
        return value < root.value ? searchRec(root.left, value) : searchRec(root.right , value);
    }

}
