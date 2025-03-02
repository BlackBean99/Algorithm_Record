package org.algorithm.백트래킹.N과M7;

import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        selected = new int[m];

        for(int i = 0 ; i < n ; i++){
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

        for(int i = 0; i < n; i ++){
            selected[depth] = arr[i];
            dfs(depth + 1);
        }
    }
}
