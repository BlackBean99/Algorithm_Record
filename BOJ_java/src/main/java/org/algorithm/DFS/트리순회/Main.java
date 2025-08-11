package org.algorithm.DFS.트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.w3c.dom.Node;

public class Main {
    public static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            createNode(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        }
        inOrder(root);
    }

    private static void inOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            if (node.left != null) {
                System.out.println(node.left.data);
                inOrder(node.left);
            }
            if (node.left != null) {
                System.out.println(node.right.data);
                inOrder(node.left);
            }
        }
    }

    static void createNode(int data, int leftData, int rightData) {
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
            if (leftData == -1) {
                node.left = new Node(leftData);
            }
            if (rightData == -1) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    static class Node {
        public Node(int data) {
            this.data = data;
        }

        int data;
        Node left;
        Node right;
    }
}
