package org.algorithm.백트래킹.N과M4;


import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[m];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth){
        if(depth == m){
            for(int value: arr){
                sb.append(value + " ");
            }
            sb.append('\n');
            return;       
        }

        // depth가 0이면 1부터 시작, 아니면 이전 값부터 시작하여 오름차순 유지
        for (int i = (depth == 0 ? 1 : arr[depth - 1]); i <= n; i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }
}