import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Integer>[] preList; // preList[i] : i 건물의 선행 건물 목록
    static int[] buildTime;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        preList = new ArrayList[n + 1];
        buildTime = new int[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) preList[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int value = Integer.parseInt(st.nextToken());
                if (value == -1) break;
                preList[i].add(value); // i 건물의 선행 건물
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++){
            sb.append(dfs(i)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int dfs(int i) {
        if (visited[i]) return dp[i];
        visited[i] = true;

        int maxPreTime = 0;
        for (int pre : preList[i]) {
            maxPreTime = Math.max(maxPreTime, dfs(pre));
        }

        dp[i] = buildTime[i] + maxPreTime;
        return dp[i];
    }
}