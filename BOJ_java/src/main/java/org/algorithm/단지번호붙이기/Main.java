package org.algorithm.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int sectorId = 1;
    static boolean[][] visited;
    static int[][] map;

    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        List<Integer> countList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = bfs(i, j, sectorId);
                if (count != 0) {
                    countList.add(count);
                }
            }
        }
        System.out.println(countList.size());
        Collections.sort(countList);

        for (Integer temp : countList) {
            System.out.println(temp);
        }

        // sectorId
        // sectorCount
    }

    private static int bfs(int x, int y, int sectorId) {
        Queue<int[]> q = new LinkedList<>();
        if (visited[x][y] || map[x][y] == 0) return 0;
        q.add(new int[] {x, y});
        map[x][y] = sectorId;
        visited[x][y] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;
                map[nx][ny] = sectorId;
            }
            count++;
        }
        if (count != 0) sectorId++;
        return count;
    }
}
