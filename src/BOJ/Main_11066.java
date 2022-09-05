package BOJ;

import java.io.*;

public class Main_11066 {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int iter = 0; iter<T;iter++){
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split( " ");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            bw.write(solution(arr) + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static int solution(int[] arr) {
        int dp[][] = new int[arr.length][arr.length];
        int s[] = new int[arr.length];
        s[0] = arr[0];
//        부분합 계산
        for (int i = 1; i < arr.length; i++) {
            s[i] = s[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length-1; i++) {
            dp[i][i+1] = arr[i] + arr[i+1];
        }

        for (int gap = 2; gap < arr.length; gap++) {
            for (int i = 0; i+gap < arr.length; i++) {
                int j = i + gap;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][k] + dp[k + 1][j] + sum(s, i, j), dp[i][j]);
                }
            }
        }
        return dp[0][arr.length - 1];
    }

    private static int sum(int[] s, int i, int j) {
        if(i == 0) return s[j];
        else return s[j] - s[i - 1];
    }


}