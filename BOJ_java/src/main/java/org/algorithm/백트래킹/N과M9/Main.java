package org.algorithm.백트래킹.N과M9;


import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];
        ans = new LinkedHashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);  // 사전순 출력을 위해 정렬
        dfs(0);  // 백트래킹 시작
        ans.forEach(System.out::print);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            sb = new StringBuilder();
            for(int value: selected){
                sb.append(value + " " );
            }
            sb.append("\n");
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = arr[i];  // 현재 숫자 선택
            dfs(depth + 1);  // 같은 숫자 선택 가능
            visited[i] = false;

        }
    }
}
