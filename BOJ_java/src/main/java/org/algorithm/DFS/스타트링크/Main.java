package org.algorithm.DFS.스타트링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;
    static int answer = -1;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new int[F + 1];
        dfs(S, G);
    }

    private static void dfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (current == end) {
                System.out.println(visited[current] - 1);
            }
            if (current + U <= F && visited[current + U] == 0) {
                visited[current + U] = visited[current] + 1;
                q.add(current + U);
            }
            if (current - D >= 1 && visited[current - D] == 0) {
                visited[current - D] = visited[current] + 1;
                q.add(current - D);
            }
        }
        if (visited[end] == 0) {
            System.out.println("use the stairs");
        }
    }
}
