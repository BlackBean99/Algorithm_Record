package org.algorithm.백트래킹.N과M10;

import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> set = new LinkedHashSet<>();
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
        set.forEach(System.out::print);
    }
    private static void dfs(int depth, int start) {
        if(start > n) return;
        if(depth == m){
            sb = new StringBuilder();
            for(int value : selected){
                sb.append(value + " ");
            }
            sb.append("\n");
            set.add(sb.toString());
            return;
        }
        for(int i = start; i < n; i++){

            selected[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}
