package org.algorithm.백트래킹.N과M12;

import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];
        st =  new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0);
        System.out.println(sb);
    }
    private static void dfs(int depth,int start) {
        if(depth == m){
            for(int value : selected){
                sb.append(value + " ");
            }
            sb.append("\n");
            return;
        }
        int before = -1;
		for(int i=start; i<n; i++) {
            if(before != arr[i]){
                before = arr[i];
                selected[depth] = arr[i];
                dfs(depth + 1, i);
            }
        }
    }
}
