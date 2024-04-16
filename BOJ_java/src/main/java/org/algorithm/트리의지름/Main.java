package org.algorithm.트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class Main {
    static List<Node> list[];
    static boolean[] visited;
    static int max = 0;
    static int max_idx = 0;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            list[Integer.parseInt(s[0])].add(
                    new Node(Integer.parseInt(s[1]), Integer.parseInt(s[2])));
            list[Integer.parseInt(s[1])].add(
                    new Node(Integer.parseInt(s[0]), Integer.parseInt(s[2])));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }

    private static void dfs(int index, int cost) {
        if (max < cost) {
            max = cost;
            max_idx = index;
        }
        for (Node a : list[index]) {
            if (!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, a.cnt + cost);
            }
        }
    }

    static class Node {
        int idx, cnt;

        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
