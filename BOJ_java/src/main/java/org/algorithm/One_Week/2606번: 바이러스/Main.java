import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n+1];
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.println(count-1);
    }
    static void dfs(int node) {
        visited[node] = true;
        count++;
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
    }
}