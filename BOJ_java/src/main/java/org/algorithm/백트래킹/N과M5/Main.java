package org.algorithm.백트래킹.N과M5;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];  // 입력받을 N개의 자연수 배열
        selected = new int[M]; // 선택된 M개의 수열을 저장할 배열
        visited = new boolean[N]; // 방문 체크 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 사전순 출력을 위해 정렬

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == M) { // M개를 모두 선택했을 경우 출력
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++){
            if(!visited[i])
                visited[i] = true;
                selected[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

