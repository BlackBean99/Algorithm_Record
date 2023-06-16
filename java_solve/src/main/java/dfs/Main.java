package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        int x = Integer.parseInt(s[3]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            graph.get(a).add(b);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        distance[k] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int a : graph.get(now)) {
                if (distance[a] > distance[now] + 1) {
                    distance[a] = distance[now] + 1;
                    q.add(a);
                }
            }
        }
//        최단거리가 k인 도시가 없을 경우 -1 출력

        boolean found = false;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}