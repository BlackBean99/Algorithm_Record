package org.algorithm.구현.미세먼지안녕;

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
        for (int i = 0; i < t; i++) {
            map = bfs();
            airSimulation();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
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

    private static int[][] bfs() {
        int[][] tMap = new int[50][50];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == -1) {
                    tMap[i][j] = -1;
                    continue;
                }
                tMap[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                    if (map[ny][nx] == -1) continue;

                    tMap[ny][nx] += (map[i][j] / 5);
                    tMap[i][j] -= (map[i][j] / 5);
                }
            }
        }
        return tMap;
    }
    //        한번 확산이 다 끝나면?

    public static void airSimulation() {
        int top = upCycle[0]; // 공기청정기 윗 부분좌표며,  반시계 방향으로 진행

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][c - 1] = map[x + 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0; // 공기청정기로 나가는 곳이므로 먼지는 0이다.

        int bottom = downCycle[0]; // 공기청정기 밑 부분좌표며, 시계방향으로 진행

        for (int x = bottom + 1; x < r - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < c - 1; y++) {
            map[r - 1][y] = map[r - 1][y + 1];
        }

        for (int x = r - 1; x > bottom; x--) {
            map[x][c - 1] = map[x - 1][c - 1];
        }

        for (int y = c - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0;
    }
}
