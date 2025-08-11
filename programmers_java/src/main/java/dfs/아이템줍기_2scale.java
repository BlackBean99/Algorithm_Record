package dfs;

import java.util.*;

class Solution {
    int[][] map;
    boolean[][] visited;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int size = 102;  // 좌표를 2배로 확장하므로 충분한 크기 설정
        map = new int[size][size];
        visited = new boolean[size][size];

        // 1. 좌표를 2배로 확장하여 맵을 채움
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] != 2) { // 이미 내부(2)로 설정되지 않았다면 가장자리(1)로 설정
                            map[i][j] = 1;
                        }
                    } else {
                        map[i][j] = 2; // 내부는 2로 설정
                    }
                }
            }
        }

        // 2. BFS로 최단거리 찾기
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1], dist = now[2];

            if (x == endX && y == endY) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}
