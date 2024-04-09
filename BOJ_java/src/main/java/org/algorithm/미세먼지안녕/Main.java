package org.algorithm.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, t;
    static int[][] map;
    static int[] upCycle;
    static int[] downCycle;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[] ddy = new int[] {0, -1, 0, 1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        t = Integer.parseInt(s[2]);
        map = new int[r][c];
        StringTokenizer st;
        q = new LinkedList<>();
        upCycle = null;
        downCycle = null;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value > 0) {
                    q.add(new int[] {i, j});
                } else if (value == -1) {
                    if (upCycle != null) {
                        downCycle = new int[] {i, j};
                    } else {
                        upCycle = new int[] {i, j};
                    }
                }
            }
        }
        bfs();
        System.out.println(getTotalDust());
    }

    private static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }

    private static void bfs() {
        while (t != 0) {
            while (!q.isEmpty()) {
                int[] now = q.poll();
                int spreadCnt = 0;
                for (int i = 0; i < 4; i++) {
                    if (now[0] >= 0
                            && now[0] < r
                            && now[1] >= 0
                            && now[1] < c
                            && map[now[0]][now[1]] != 1) {
                        spreadCnt++;
                    }
                }
                int add = (map[now[0]][now[1]] / 5);

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[0] + dy[i];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny] != 1) {
                        map[nx][ny] += add;
                        map[nx][ny] -= (add * spreadCnt);
                    }
                }
            }
            // 다시 큐 채우기
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0) {
                        q.add(new int[] {i, j});
                    }
                }
            }
            // 환풍기로 한번 밀기
            circular();
            t -= 1;
        }
        //        한번 확산이 다 끝나면?

    }

    private static void circular() {
        // 상단 회전
        int temp = 0;
        int[] now = new int[] {upCycle[0] + dx[0], upCycle[1] + dy[0]};

        for (int i = 0; i < 4; i++) {
            int nux = now[0] + dx[i];
            int nuy = now[1] + dy[i];
            while (nux >= 0 && nux < r && nuy >= 0 && nuy < c && map[nux][nuy] != 1) {

                temp = map[nux][nuy];
                map[nux][nuy] = map[now[0]][now[1]];
                map[now[0]][now[1]] = temp;
                nux = nux + dx[i];
                nuy = nuy + dy[i];
            }
            now = new int[] {nux, nuy};
        }

        // 하단 회전
        int[] downNow = new int[] {downCycle[0] + dx[2], downCycle[1] + ddy[2]}; // 하단의 시작점 설정

        for (int i = 0; i < 4; i++) {
            int ndx = downNow[0] + dx[i];
            int ndy = downNow[1] + dy[i];
            while (ndx >= 0 && ndx < r && ndy >= 0 && ndy < c && map[ndx][ndy] != 1) {

                temp = map[ndx][ndy];
                map[ndx][ndy] = map[downNow[0]][downNow[1]];
                map[downNow[0]][downNow[1]] = temp;
                ndx = ndx + dx[i];
                ndy = ndy + dy[i];
            }
            downNow = new int[] {ndx, ndy};
        }
    }
}
