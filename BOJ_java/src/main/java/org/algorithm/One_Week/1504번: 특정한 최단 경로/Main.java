import java.util.*;
import java.io.*;

public class Main {
    static int n, e;
    static List<int[]>[] graph;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 총 3번 수행
        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long route1 = (long)dist1[v1] + distV1[v2] + distV2[n];
        long route2 = (long)dist1[v2] + distV2[v1] + distV1[n];

        long answer = Math.min(route1, route2);

        if (answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    static int[] dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[n+1];
        dist[start] = 0;
        Arrays.fill(dist, INF);

        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] > dist[cur[0]]) continue;

            for(int[] next: graph[cur[0]]){
                int ncost = cur[1] + next[1];
                if(dist[next[0]] > ncost){
                    dist[next[0]] = ncost;
                    pq.add(new int[]{next[0], ncost});
                }
            }
        }
        return dist;
    }
}
