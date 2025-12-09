import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static double[][] stars;
    static int[] parent;
    static List<Edge> edges;

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stars = new double[n][2];
        parent = new int[n];
        edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
            parent[i] = i;
        }

        // 모든 점 쌍의 거리 계산
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = getDistance(stars[i][0], stars[i][1], stars[j][0], stars[j][1]);
                edges.add(new Edge(i, j, d));
            }
        }

        Collections.sort(edges);

        double total = 0.0;

        // Kruskal MST
        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                total += e.weight;
            }
        }

        System.out.printf("%.2f\n", total);
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

    static double getDistance(double ax, double ay, double bx, double by) {
        return Math.sqrt((bx - ax) * (bx - ax) + (by - ay) * (by - ay));
    }
}
