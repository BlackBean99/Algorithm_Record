package org.algorithm.DP.동전바꿔주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int target, kind;
    static int[][] coin;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = Integer.parseInt(br.readLine());
        kind = Integer.parseInt(br.readLine());
        coin = new int[kind][2];

        StringTokenizer st = null;
        for (int i = 0; i < kind; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[kind][target + 1];
        for (int i = 0; i < kind; i++) {
            for (int j = 0; j < target; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(comb(0, 0));
    }

    static int comb(int money, int coinType) {
        if (money == target) {
            return 1;
        }
        if (coinType == kind || money > target) {
            return 0;
        }
        if (dp[coinType][money] != -1) {
            return dp[coinType][money];
        }

        int res = 0;
        // 코인을 0개부터 가지고 있는 모든 갯수를 사용한 경우를 res에 반영한다.
        for (int i = 0; i < coin[coinType][1] + 1; i++) {
            int cost = coin[coinType][0] * i;
            // 쓰고 다음 코인을 고려한다. (0개 + 다음 케이스 , 1개 + 다음 케이스 )
            res += comb(money + cost, coinType + 1);
        }
        return dp[coinType][money] = res;
    }
}
