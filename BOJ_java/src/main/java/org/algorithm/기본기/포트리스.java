package org.algorithm.기본기;

import java.util.LinkedList;
import java.util.List;

public class 포트리스 {
    static int longest;

    Integer height(Tree root) {
        List<Integer> heights = new LinkedList<>();

        for (int i = 0; i < root.children.size(); i++) {
            heights.add(height(root.children.get(i)));
        }

        // 비어있는 경우
        if(heights.isEmpty()) return 0;

        heights.sort((a, b) -> a-b);
        if (heights.size() >= 2) {
            longest = Math.max(longest,
                2 + heights.get(heights.size() - 2) + heights.get(heights.size() - 1));
        }
        return heights.get(heights.size() - 1) + 1;
    }

    public static void main(String[] args) {
// 포트리스 문제
        longest = 0;
        int h = height(root);
        System.out.println(;Math.max(longest, h));
    }

    Tree getTree(int root) {
        Tree ret = new Tree();
        for (int i = 0; i < n; i++) {
            if (isChild(root, i)) {
                ret.children.add(getTree(i));
            }
        }
        return ret;
    }
    static int n;
    static int[] y,x,radius;

    public int sqrdist(int a, int b) {
        return (x[a]-x[b])*(x[a]-x[b]) + (y[a] - y[b]) * (y[a] - y[b]);
    }

    // a가 b를 포함하는지 확인한다.
    public boolean encloses(int a, int b) {
        return radius[a] > radius[b]
            && sqrdist(a, b) < radius[a] * radius[a] - radius[b] * radius[b];
    }
    boolean isChild(int parent, int child) {
        if (!encloses(parent, child)) {
            return false;
        }
        // 직접 포함해야한다.
        for (int i = 0; i < n; i++) {
            if (i != parent && i != child && encloses(parent, i) && encloses(i, child)) {
                return false;
            }
        }
        return true;
    }
}
class Tree{
    List<Tree> children;
}
