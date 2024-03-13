package org.algorithm.촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] relation;
    static boolean[] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 변수 초기화
        relation = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            relation[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relation[parent].add(child);
            relation[child].add(parent);
        }

        // 시작, 종료, count
        dfs(x, y, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int end, int count) {
        // 종료조건
        if (start == end) {
            answer = count;
            return;
        }
        visited[start] = true;
        for (int next : relation[start]) {
            if (!visited[next]) {
                dfs(next, end, count + 1);
            }
        }
    }
}
