package org.algorithm.기본기;

import java.util.List;
import java.util.Scanner;

public class 일반트리 {
    public static void main(String[] args) {

    }

    public int getHeight(TreeNode node){
        int h = 0;
        for (int i = 0; i < node.children.size(); i++) {
            h = Math.max(h, 1 + getHeight(node.children.get(i)));
        }
        return h;
    }
    public void printTree(TreeNode node) {
        System.out.println(node.data);
        for (int i = 0; i < node.children.size(); i++) {
            printTree(node.children.get(i));
        }
    }
}
class TreeNode {
    String data;
    TreeNode parent;
    List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
    }
}
