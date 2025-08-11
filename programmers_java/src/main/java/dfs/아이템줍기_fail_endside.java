package dfs;

import java.util.*;

class Solution {
    int[][] borderline;
    int[][] map;
    boolean[][] borderVisited;
    boolean[][] visited;
    int borderLength = 15;
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] borderDx = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] borderDy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        borderline = new int[borderLength][borderLength];
        borderVisited = new boolean[borderLength][borderLength];
        visited = new boolean[borderLength][borderLength];
        map = new int[borderLength][borderLength];

        for (int[] m : map) {
            Arrays.fill(m, 0);
        }

        for (int[] rect : rectangle) {
            for (int i = rect[0]; i <= rect[2]; i++) {
                for (int j = rect[1]; j <= rect[3]; j++) {
                    map[i][j] = 1;
                }
            }
        }

        makeBorderline();

        return bfs(characterX, characterY, itemX, itemY);
    }

    private int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == itemX && now[1] == itemY) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < borderLength && ny >= 0 && ny < borderLength &&
                    !visited[nx][ny] && borderline[nx][ny] == 1) {
                    q.add(new int[]{nx, ny, now[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }

    private void makeBorderline() {
        // 1. 외부 영역을 BFS로 탐색하여 가장자리 찾기
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        borderVisited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < borderLength && ny >= 0 && ny < borderLength &&
                    !borderVisited[nx][ny] && map[nx][ny] == 0) {
                    borderVisited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    
                    for (int k = 0; k < 8; k++) {
                        int borderTargetX = nx + borderDx[k];
                        int borderTargetY = ny + borderDy[k];
                        if (borderTargetX >= 0 && borderTargetX < borderLength &&
                            borderTargetY >= 0 && borderTargetY < borderLength &&
                            map[borderTargetX][borderTargetY] == 1) {
                            borderline[borderTargetX][borderTargetY] = 1;
                        }
                    }
                }
            }
        }

        // 2. 내부 공간 탐색 및 가장자리 찾기
        for (int i = 0; i < borderLength; i++) {
            for (int j = 0; j < borderLength; j++) {
                if (map[i][j] == 0 && !borderVisited[i][j]) {
                    markInnerArea(i, j);
                }
            }
        }
    }

    private void markInnerArea(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        borderVisited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < borderLength && ny >= 0 && ny < borderLength &&
                    !borderVisited[nx][ny] && map[nx][ny] == 0) {
                    borderVisited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 내부 공간의 경계를 borderline에 반영
        for (int i = 0; i < borderLength; i++) {
            for (int j = 0; j < borderLength; j++) {
                if (borderVisited[i][j]) {
                    for (int k = 0; k < 8; k++) {
                        int borderTargetX = i + borderDx[k];
                        int borderTargetY = j + borderDy[k];
                        if (borderTargetX >= 0 && borderTargetX < borderLength &&
                            borderTargetY >= 0 && borderTargetY < borderLength &&
                            map[borderTargetX][borderTargetY] == 1) {
                            borderline[borderTargetX][borderTargetY] = 1;
                        }
                    }
                }
            }
        }
    }
}
