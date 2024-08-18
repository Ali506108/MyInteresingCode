package com.example.CourseAdult;

public class BinaryTrees {
    Node root;

    BinaryTrees() {
        root = null;
    }

    // Вставка узла в дерево
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Рекурсивный метод вставки
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Поиск узла в дереве
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Рекурсивный метод поиска
    boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        return value < root.value ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    // Метод для вывода дерева в консоль
    void printTree() {
        printTreeRec(root, 0);
    }

    // Рекурсивный метод для вывода дерева
    void printTreeRec(Node root, int level) {
        if (root == null) {
            return;
        }

        printTreeRec(root.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + root.value);
        } else {
            System.out.println(root.value);
        }

        printTreeRec(root.left, level + 1);
    }
}
