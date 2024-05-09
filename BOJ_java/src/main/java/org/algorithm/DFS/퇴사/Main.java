package org.algorithm.DFS.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] manage;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        manage = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            manage[i][0] = Integer.parseInt(st.nextToken());
            manage[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int idx, int pay) {
        if (idx >= n) {
            result = Math.max(pay, result);
            return;
        }

        if (idx + manage[idx][0] <= n) { // 상담을 끝마칠 수 있다면 -> 상담이 끝난 날짜와 상담비 넣음
            dfs(idx + manage[idx][0], pay + manage[idx][1]);
        } else {
            dfs(idx + manage[idx][0], pay);
        }
        dfs(idx + 1, pay);
    }
}
