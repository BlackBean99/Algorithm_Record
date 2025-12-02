import java.util.*;

public class NavigationProblem {
    static class Edge {
        int to, dist, color;
        Edge(int to, int dist, int color) {
            this.to = to;
            this.dist = dist;
            this.color = color;
        }
    }

    static Map<Integer, List<Edge>>  graph = new HashMap<>();
    static int N; // 최대 노드 번호
    static int[][] shortestDist; // 최단 거리
    static Map<String, Boolean> isOnShortestPath = new HashMap<>();

    public static void main(String[] args) {
        int[][] route = {
            {1,2,3,1}, {2,4,1,2}, {2,5,5,4}, {4,5,4,1},
            {1,5,4,2}, {5,6,5,3}, {1,6,7,4}, {1,3,4,3}, {3,6,2,1}
        };
        int[] routeColor = {1, -4, 2};

        // 1. 그래프 구성
        N = 0;
        for (int[] r : route) {
            int u = r[0], v = r[1], dist = r[2], color = r[3];
            N = Math.max(N, Math.max(u, v));
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, dist, color));
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, dist, color));
        }

        // 2. 모든 쌍 최단 거리 계산 (Dijkstra)
        shortestDist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(shortestDist[i], Integer.MAX_VALUE);
            dijkstra(i, shortestDist[i]);
        }




        // 3. 최단 경로에 포함되는 간선 판정
        for (int u = 1; u <= N; u++) {
            // 중간에 지나가는 간선이 최단 경로에 포함되는지 확인
            for (Edge e : graph.getOrDefault(u, new ArrayList<>())) {
                for (int target = 1; target <= N; target++) {
                    if (shortestDist[u][target] != Integer.MAX_VALUE &&
                        shortestDist[u][target] == e.dist + shortestDist[e.to][target]) {
                        String key = u + "-" + e.to + "-" + target;
                        isOnShortestPath.put(key, true);
                    }
                }
            }
        }

        // 4. 경로 탐색
        Set<List<Integer>> result = new HashSet<>();
        for (int start = 1; start <= N; start++) {
            dfs(start, start, 0, routeColor, result);
        }

        // 5. 출력
        List<List<Integer>> sorted = new ArrayList<>(result);
        sorted.sort((a,b) -> a.get(0) == b.get(0) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        System.out.println(sorted);
    }

    static void dfs(int start, int current, int idx, int[] routeColor, Set<List<Integer>> result) {
        if(idx == routeColor.length) {
            if(start != current) {
                result.add(Arrays.asList(start, current));
            }
            return;
        }
        int color = Math.abs(routeColor[idx]);
        boolean mustBeShortest = routeColor[idx] > 0;

        for(Edge e : graph.getOrDefault(current, new ArrayList<>())) {
            if(e.color == color) {
                boolean onShortest = false;
                for(int target = 1; target <= N; target++) {
                    String key = current + "-" + e.to + "-" + target;
                    if(isOnShortestPath.getOrDefault(key, false)) {
                        onShortest = true;
                        break;
                    }
                }
                
                if(mustBeShortest && !onShortest) continue;
                if(!mustBeShortest && onShortest) continue;

                dfs(start, e.to, idx+1, routeColor, result);
            }
        }
    }

    static void dfs(int start, int current, int idx, int[] routeColor, Set<List<Integer>> result) {
        if (idx == routeColor.length) {
            if (start != current) {
                result.add(Arrays.asList(start, current));
            }
            return;
        }

        int color = Math.abs(routeColor[idx]);
        boolean mustBeShortest = routeColor[idx] > 0;

        for (Edge e : graph.getOrDefault(current, new ArrayList<>())) {
            if (e.color == color) {
                boolean onShortest = false;
                // 해당 간선이 최단 경로 조건에 맞는지 확인
                for (int target = 1; target <= N; target++) {
                    String key = current + "-" + e.to + "-" + target;
                    if (isOnShortestPath.getOrDefault(key, false)) {
                        onShortest = true;
                        break;
                    }
                }

                if (mustBeShortest && !onShortest) continue;
                if (!mustBeShortest && onShortest) continue;

                dfs(start, e.to, idx + 1, routeColor, result);
            }
        }
    }
    static void dijkstra(int start, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], cost = cur[1];
            if (cost > dist[u]) continue;

            for (Edge e : graph.getOrDefault(u, new ArrayList<>())) {
                if (dist[e.to] > dist[u] + e.dist) {
                    dist[e.to] = dist[u] + e.dist;
                    pq.offer(new int[]{e.to, dist[e.to]});
                }
            }
        }
    }
}
