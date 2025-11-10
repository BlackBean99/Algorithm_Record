package org.algorithm.BFS.연우의배수로뚫기;

import java.util.*;
import java.io.*;

public class Main {
    static int[] arr, digging;
    static int[] leftMax, rightMax, water;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        // 배수구
        int m = Integer.parseInt(br.readLine());
        digging = new int[m];
        for (int i = 0; i < m; i++){
            digging[i] = Integer.parseInt(br.readLine()) - 1;
        }


        leftMax = new int[n];
        rightMax = new int[n];
        water = new int[n];

        // 왼쪽, 오른쪽 최대 높이
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }

        // 물 높이 계산
        long totalWater = 0;
        for (int i = 0; i < n; i++) {
            water[i] = Math.max(0, Math.min(leftMax[i], rightMax[i]) - arr[i]);
            totalWater += water[i];
        }

        // 무향 그래프 연결
        graph = new int[n][2];
        for(int i = 1; i < n-1; i++){
            int[] tmp = new int[2];
            tmp[0] = -1;
            tmp[1] = -1;
            if (arr[i] + water[i] > arr[i + 1])
                tmp[1] = i + 1;
            if (arr[i] + water[i] > arr[i - 1])
                tmp[0] = i - 1;
            graph[i] = tmp;
        }

        System.out.println(totalWater);
        for(int dig: digging){
            int value = dfs(dig);
            System.out.println(value);
        }
    }
    static int dfs(int dig){
        int value = 0;
        // dig부터 dfs해서 뽑아내는 물을 다 누적
        visited[dig] = true;
        Stack<Integer> stack = new Stack<>();
        stack.add(dig);
        value += water[dig];
        while(!stack.isEmpty()){
            int cur = stack.pop();
            int[] lr = graph[cur];
            if(lr[0] != -1 && !visited[lr[0]]){
                value += water[lr[0]];
                water[lr[0]] = 0;
                visited[lr[0]] = true;
                stack.add(lr[0]);
            }
            if(lr[1] != -1 && !visited[lr[1]]){
                water[lr[1]] = 0;
                value += water[lr[1]];
                visited[lr[1]] = true;
                stack.add(lr[1]);
            }
        }
        return value;
    }
}
