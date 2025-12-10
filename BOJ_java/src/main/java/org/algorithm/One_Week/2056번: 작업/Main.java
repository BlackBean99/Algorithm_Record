import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] time = new int[n+1];
        int[] indegree = new int[n+1];
        int[] dp = new int[n+1];

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br .readLine());
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indegree[i]++;
            }
            
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if(indegree[i] == 0){
                q.add(i);
                dp[i] = time[i];
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt: graph[cur]){
                dp[nxt] = Math.max(dp[nxt], dp[cur] + time[nxt]);

                indegree[nxt]--;
                if(indegree[nxt] == 0) q.add(nxt);
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer,dp[i]);
        }
        System.out.println(answer);
    }
}