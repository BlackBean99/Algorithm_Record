package org.algorithm.백트래킹.N과M8;

import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0,0);

        System.out.println(sb);
    }

    private static void dfs(int depth, int start) {
        if (depth == m) { // M개를 모두 선택했을 경우 출력
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) { // **이전 숫자 이후만 선택 가능**
            selected[depth] = arr[i]; // 현재 숫자 선택
            dfs(depth + 1, i); // **같은 숫자도 다시 선택 가능**
        }
    }
}
