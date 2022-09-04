package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2315 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[] loc, sum;
    static long[][][] dp = new long[1005][1005][2];

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        loc = new int[n + 1];
        sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            loc[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 1005; ++i) {
            for (int j = 0; j < 1005; ++j) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
    }

    static long solve(int left, int right, int isLeft) {
//        base condition
        if (left == 1 && right == n) {
            return 0;
        }
//      등록되지 않은 정보
        if (dp[left][right][isLeft] != -1) {
            return dp[left][right][isLeft];
        }
// 오른쪽에 있으면 curLoc = left, 아니면 right
        int curLoc = isLeft == 0 ? left : right;
        long result = Long.MAX_VALUE;
//        왼쪽으로 쭉 이동 / left 가 1일 될때까지
        if (left > 1) {
            result = solve(left - 1, right, 0) + (long) (loc[curLoc] - loc[left - 1]) *
                    (sum[n] - sum[right] + sum[left - 1]);
        }
        if (right < n) {
            result = Math.min(
                    result,
                    solve(left, right + 1, 1) + (long) (loc[right + 1] - loc[curLoc]) *
                            (sum[n] - sum[right] + sum[left - 1])
            );
        }
        dp[left][right][isLeft] = result;
        return result;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve(m, m, 0));
    }
}