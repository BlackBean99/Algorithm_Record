import java.util.*;
import java.io.*;
public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        @SuppressWarnings("unchecked")
        List<Integer>[] temp = new ArrayList[n + 1];
        graph = temp;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for(int i = 1; i <= n; i++){
            Collections.sort(graph[i]);
        }
        visited = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        dfs(v, sb);
        System.out.println(sb.toString().trim());

        visited = new boolean[n+1];
        sb = new StringBuilder();
        bfs(v, sb);
        System.out.println(sb.toString().trim());
    }
    static void dfs(int start, StringBuilder sb) {
        visited[start] = true;
        sb.append(start).append(" ");
        for(int value: graph[start]){
            if(!visited[value]) dfs(value, sb);
        }
    }
    static void bfs(int start, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}