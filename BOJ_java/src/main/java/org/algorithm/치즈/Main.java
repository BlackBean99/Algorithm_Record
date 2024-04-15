package org.algorithm.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, czSize;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        czSize = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    czSize++;
                }
            }
        }
        int cheese = 0;
        int time = 0;
        while (czSize != 0) {
            time++;
            cheese = czSize;
            visited = new boolean[n][m];
            bfs();
        }
        System.out.println(time);
        System.out.println(cheese);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        czSize--;
                    } else {
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}
