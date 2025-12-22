import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 1️⃣ 임의 노드(1)에서 가장 먼 노드 A 찾기
        int[] dist1 = bfs(1);
        int A = getFarthestNode(dist1);

        // 2️⃣ A에서 가장 먼 노드 B 찾기
        int[] distA = bfs(A);
        int B = getFarthestNode(distA);

        // 3️⃣ B에서 거리 계산
        int[] distB = bfs(B);

        // 4️⃣ 중심 계산
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, Math.max(distA[i], distB[i]));
        }

        System.out.println(answer);
    }

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
        return dist;
    }

    static int getFarthestNode(int[] dist) {
        int maxDist = -1;
        int node = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                node = i;
            }
        }
        return node;
    }
}
