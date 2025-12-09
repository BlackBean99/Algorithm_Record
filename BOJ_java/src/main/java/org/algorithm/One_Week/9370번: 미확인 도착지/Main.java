import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t;
    static int s, g, h;
    static List<int[]>[] graph;
    static final int INF = 2_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++)
                graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});
            }

            int[] candidates = new int[t];
            for (int i = 0; i < t; i++)
                candidates[i] = Integer.parseInt(br.readLine());

            // 다익스트라 3번만 실행
            int[] distS = dijkstra(s);
            int[] distG = dijkstra(g);
            int[] distH = dijkstra(h);

            ArrayList<Integer> answer = new ArrayList<>();

            for (int x : candidates) {

                long path1 = (long)distS[g] + distG[h] + distH[x];
                long path2 = (long)distS[h] + distH[g] + distG[x    ];

                if (distS[x] == path1 || distS[x] == path2)
                    answer.add(x);
            }

            Collections.sort(answer);
            for (int x : answer) sb.append(x).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue;

            for (int[] nxt : graph[now]) {
                int next = nxt[0];
                int nextCost = cost + nxt[1];

                if (dist[next] > nextCost) {
                    dist[next] = nextCost;
                    pq.add(new int[]{next, nextCost});
                }
            }
        }

        return dist;
    }
}
