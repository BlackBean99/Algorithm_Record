import java.util.*;
import java.io.*;

public class Main {
    static int v, e;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;
        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o){
            return this.weight - o.weight;
        }
    }
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[v + 1];
        for (int i = 1; i <= v; i++) parent[i] = i;

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        // 1. 간선들을 가중치 기준으로 정렬
        Collections.sort(edges);

        // 2. 크루스칼로 MST 구성
        int mstWeight = 0;
        int usedEdges = 0;

        for (Edge edge : edges) {
            if (union(edge.from, edge.to)) { // 사이클이 안 생기면 채택
                mstWeight += edge.weight;
                usedEdges++;
                if (usedEdges == v - 1) break; // MST 완성
            }
        }

        System.out.println(mstWeight);
    }

    // find: 대표 노드 찾기 (경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // union: 두 집합 합치기, 합쳤으면 true, 이미 같은 집합이면 false
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false; // 이미 같은 집합 → 간선 채택 X (사이클)
        parent[b] = a;
        return true;
    }
}
