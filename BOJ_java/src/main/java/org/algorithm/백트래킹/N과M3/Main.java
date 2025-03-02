package org.algorithm.백트래킹.N과M3;


import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        // 최대 길이인 경우 끝
        if(depth == m){
            for(int i = 0; i < m; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
            return;
        }
        //길이가 1씩 늘랴가면서, dfs를 재귀 호출한다.
        for(int i = 1; i <= n; i++){
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}
