import java.util.*;
import java.io.*;

public class Main {
    static int v, e, start;
    static List<int[]>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[begin].add(new int[]{end, weight});
        }

        dist = new int[v + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=v; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb.toString());

    }

    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, dist[start]});
        boolean[] visited = new boolean[v+1];
        // visited[start] = true;s
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            
            if(visited[node]) continue;
            visited[node] = true;
            for(int [] edge: graph[node]){
                if(dist[edge[0]]  > edge[1] + dist[node]){
                    dist[edge[0]] = edge[1] + dist[node];
                    pq.add(new int[]{edge[0], dist[edge[0]]});
                }
            }
        }
    }
}