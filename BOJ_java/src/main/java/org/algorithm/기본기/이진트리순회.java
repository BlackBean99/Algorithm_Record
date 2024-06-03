package org.algorithm.기본기;

import java.util.Scanner;

public class 이진트리순회 {
    public static Node root; //초기 root는 null
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        이진트리순회 t = new 이진트리순회();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            t.createNode(a, b, c);
        }
        System.out.println("전위 순회");
        t.preOrder(t.root);

        System.out.println("\n중위 순회");
        t.inOrder(t.root);

        System.out.println("\n후위 순회");
        t.postOrder(t.root);
    }


    public static void createNode(int data, int leftData, int rightData) {
        if (root == null) {
            root = new Node(data);

            if (leftData != -1) {
                root.left = new Node(leftData);
            }
            if (rightData != -1) {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public static void searchNode(Node node, int data, int leftData, int rightData) {
        if (node == null) {
            return;
        } else if (node.data == data) {
            if (leftData != -1) {
                node.left = new Node(leftData);
            }
            if (rightData != -1) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData); // 왼쪽 재귀 탐색
            searchNode(node.right, data, leftData, rightData); // 오른쪽 재귀 탐색
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + "");
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }


    public void inOrder(Node node) {
        if (node != null) {
            if(node.left != null) preOrder(node.left);
            System.out.print(node.data + "");
            if(node.right != null) preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
            System.out.print(node.data + "");
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

}
