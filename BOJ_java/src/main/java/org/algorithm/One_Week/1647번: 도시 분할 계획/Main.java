import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w));
        }

        // 간선 비용 기준 정렬
        Collections.sort(edges);

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int totalCost = 0;  
        int maxEdge = 0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                totalCost += e.weight;
                maxEdge = Math.max(maxEdge, e.weight);
            }
        }

        for(Edge e: edges){
            if(union(e.from, e.to)){
                totalCount += e.weight;
                maxEdge = Math.max(maxEdge, e.weight);
            }
        }
        // 도시를 두 구역으로 나누기 위해 가장 큰 간선 제거
        System.out.println(totalCost - maxEdge);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}