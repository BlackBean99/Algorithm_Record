import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] parent;
    static int[] plan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());  // 도시 수
        m = Integer.parseInt(br.readLine());  // 여행 계획 길이

        parent = new int[n + 1];
        plan = new int[m];

        // 초기 부모 세팅
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 그래프 입력 & Union-Find 병합
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if(connected == 1){
                    union(i,j);
                }
            }
        }

        // 여행 계획
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        // 첫 도시의 루트와 일치하는지 확인
        int root = find(plan[0]);
        for (int i = 1; i < m; i++) {
            if (root != find(plan[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }


    static int find(int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = find(parent[node]);
    }


    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
}
