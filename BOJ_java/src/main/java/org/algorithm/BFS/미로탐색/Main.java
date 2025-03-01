package org.algorithm.BFS.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(map, n, m);
    }

    private static void bfs(int[][] map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0,1,0,-1};
        int[] dy =  {1,0,-1,0};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0] == n-1 && cur[1] == m-1){
                System.out.println(cur[2]);
                return;
            }

            for(int i = 0; i < 4 ; i++){
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];
                int depth = cur[2];

                if(x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || map[x][y] == 0) continue;
                queue.offer(new int[]{x,y, depth + 1});
                visited[x][y] = true;
            }
        }
    }
}
