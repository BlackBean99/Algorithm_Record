package org.algorithm.DFS.ABCDE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> relation;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        relation = new LinkedList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            relation.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int cnt) {
        if (cnt == 4) {
            answer = 1;
            return;
        }

        for (Integer a : relation.get(start)) {
            if (!visited[a]) {
                visited[a] = true;
                dfs(a, cnt + 1);
                visited[a] = false;
            }
        }
    }
}
