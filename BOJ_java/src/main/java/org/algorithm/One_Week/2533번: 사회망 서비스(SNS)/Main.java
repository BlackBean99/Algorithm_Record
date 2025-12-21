import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 트리 입력
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // DFS 시작 (루트 1)
        dfs(1);

        // 루트가 얼리 어답터일 수도, 아닐 수도 있음
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int cur) {
        visited[cur] = true;
        dp[cur][0] = 0; // 얼리 어답터 아님
        dp[cur][1] = 1; // 얼리 어답터임 (자기 자신 포함)

        for (int next : graph[cur]) {
            if (!visited[next]) {
                dfs(next);

                // cur이 얼리 어답터일 때
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);

                // cur이 얼리 어답터가 아닐 때
                dp[cur][0] += dp[next][1];
            }
        }
    }
}
