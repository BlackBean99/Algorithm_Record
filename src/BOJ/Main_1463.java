package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main_1463 {
    private static int dp[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+2];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            if(i % 2 == 0) dp[i] = min(dp[i],dp[i/2]+1);
            if(i % 3 == 0) dp[i] = min(dp[i],dp[i/3] +1);
        }
        System.out.println(dp[n]);
    }
}
