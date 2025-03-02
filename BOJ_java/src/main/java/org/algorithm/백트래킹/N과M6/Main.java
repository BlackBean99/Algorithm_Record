package org.algorithm.백트래킹.N과M6;


import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] selected;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];

        for(int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth){
        if(depth == m){
            for(int value: selected){
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = depth; i < n; i++){
            if(!visited[i]){
                if(depth > 0 && selected[depth-1] > arr[i]) continue;
                selected[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
    
}
