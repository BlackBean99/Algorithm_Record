import java.io.*;
import java.util.*;

class Location {
    int rx, ry, bx, by, count;

    public Location(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int holeX, holeY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        
        int redX = 0, redY = 0, blueX = 0, blueY = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'R') {
                    redX = i;
                    redY = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'B') {
                    blueX = i;
                    blueY = j;
                    map[i][j] = '.';
                } else if (map[i][j] == 'O') {
                    holeX = i;
                    holeY = j;
                }
            }
        }
        
        System.out.println(bfs(redX, redY, blueX, blueY));
    }

    static int bfs(int redX, int redY, int blueX, int blueY) {
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(redX, redY, blueX, blueY, 0));
        visited[redX][redY][blueX][blueY] = true;

        while (!queue.isEmpty()) {
            Location cur = queue.poll();
            int curCount = cur.count;

            if (curCount >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int newRx = cur.rx;
                int newRy = cur.ry;
                int newBx = cur.bx;
                int newBy = cur.by;
                
                // 파란 구슬 먼저 이동 (빨간 구슬 먼저 이동하는 경우와 위치 조정 로직에서 다름)
                // 기울이는 방향에 따라 먼저 이동하는 구슬을 별도로 판단하여 구현할 수 있지만,
                // 이 코드에서는 일단 각각 이동시킨 후 겹칠 때 위치 조정하는 방식으로 단순화
                
                // 빨간 구슬 이동
                while (map[newRx + dx[i]][newRy + dy[i]] != '#' && (newRx != holeX || newRy != holeY)) {
                    newRx += dx[i];
                    newRy += dy[i];
                }

                // 파란 구슬 이동
                while (map[newBx + dx[i]][newBy + dy[i]] != '#' && (newBx != holeX || newBy != holeY)) {
                    newBx += dx[i];
                    newBy += dy[i];
                }


                if (newRx == cur.rx && newRy == cur.ry && newBx == cur.bx && newBy == cur.by) {
                    continue;
                }

                if (newBx == holeX && newBy == holeY) {
                    continue; // 파란 구슬이 구멍에 빠지면 실패이므로, 이 경우는 건너뜀
                }

                if (newRx == holeX && newRy == holeY) {
                    return curCount + 1; // 빨간 구슬만 구멍에 빠지면 성공
                }

                // 구슬이 겹치는 경우
                if (newRx == newBx && newRy == newBy) {
                    // 원래 위치를 비교해서 더 나중에 출발한 구슬을 한 칸 뒤로
                    switch (i) {
                        case 0: // 위
                            if (cur.rx < cur.bx) newBx -= dx[i]; // 파란 구슬이 더 아래에 있었으면 파란 구슬 되돌리기
                            else newRx -= dx[i];
                            break;
                        case 1: // 오른쪽
                            if (cur.ry > cur.by) newBy -= dy[i];
                            else newRy -= dy[i];
                            break;
                        case 2: // 아래
                            if (cur.rx > cur.bx) newBx -= dx[i];
                            else newRx -= dx[i];
                            break;
                        case 3: // 왼쪽
                            if (cur.ry < cur.by) newBy -= dy[i];
                            else newRy -= dy[i];
                            break;
                    }
                }

                // 새로운 위치 조합을 방문하지 않았다면 큐에 추가
                if (!visited[newRx][newRy][newBx][newBy]) {
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Location(newRx, newRy, newBx, newBy, curCount + 1));
                }
            }
        }

        return -1; // 10번 안에 성공하지 못하면 -1 반환
    }
}