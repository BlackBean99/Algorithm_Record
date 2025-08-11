package org.algorithm.BFS.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[][] map;
    static int[][] visited;
    static List<Integer> answers;
    static int n;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];
        answers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] a = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(a[j]);
            }
        }
        bfs();
        answers.sort(
                (o1, o2) -> {
                    return o1 - o2;
                });
        System.out.println(answers.size());
        for (int a : answers) {
            System.out.println(a);
        }
    }

    public static void bfs() {
        int index = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    int cnt = bfsProcess(i, j, index);
                    if (cnt > 0) {
                        answers.add(cnt);
                        index++;
                    }
                }
            }
        }
    }

    public static int bfsProcess(int i, int j, int index) {
        int[] start = new int[] {i, j};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        map[i][j] = index;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = now[0] + dx[dir];
                int ny = now[1] + dy[dir];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                    map[nx][ny] = index;
                    q.add(new int[] {nx, ny});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*

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
*/
