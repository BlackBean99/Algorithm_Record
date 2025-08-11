package org.algorithm.트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Node>[] tree;
    static int node = 0;
    static int max = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            while (true) {
                int data = Integer.parseInt(st.nextToken());
                if (data == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree[index].add(new Node(data, weight));
            }
        }
        // 랜덤으로 아무거나 짚어서 마지막 노드를 확인해보자.
        visited = new boolean[n + 1];
        dfs(1, 0);
        visited = new boolean[n + 1];
        dfs(node, 0);
        System.out.println(max);
    }

    static void dfs(int current, int cost) {
        if (cost > max) {
            max = cost;
            node = current;
        }
        visited[current] = true;
        for (int i = 0; i < tree[current].size(); i++) {
            Node data = tree[current].get(i);
            if (visited[data.data] == false) {
                visited[data.data] = true;
                dfs(data.data, cost + data.weight);
            }
        }
    }

    static class Node {
        int data;
        int weight;

        public Node(int data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }
}
