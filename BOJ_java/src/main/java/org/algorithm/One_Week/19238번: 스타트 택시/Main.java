import java.util.*;
import java.io.*;

public class Main {
    static int n, m, fuel;
    static int[][] map;
    static int sx, sy;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static class Passenger {
        int sx, sy, ex, ey;
        Passenger(int sx, int sy, int ex, int ey) {
            this.sx=sx; this.sy=sy; this.ex=ex; this.ey=ey;
        }
    }

    static Map<String, Passenger> passengers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken()) - 1;
        sy = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            passengers.put(a + "," + b, new Passenger(a, b, c, d));
        }

        for (int i = 0; i < m; i++) {
            int[] picked = findPassenger();

            if (picked == null) {
                System.out.println(-1);
                return;
            }
            int px = picked[0], py = picked[1], distToP = picked[2];

            fuel -= distToP;
            if (fuel < 0) { System.out.println(-1); return; }

            Passenger p = passengers.remove(px + "," + py);

            int distToDest = bfs(px, py, p.ex, p.ey);
            if (distToDest == -1) {
                System.out.println(-1);
                return;
            }

            fuel -= distToDest;
            if (fuel < 0) { System.out.println(-1); return; }

            fuel += distToDest * 2;

            sx = p.ex;
            sy = p.ey;
        }

        System.out.println(fuel);
    }

    static int[] findPassenger() {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        int minDist = Integer.MAX_VALUE;
        int fx=-1, fy=-1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];

            if (d > minDist) break;

            if (passengers.containsKey(x + "," + y)) {
                if (d < minDist ||
                    (d == minDist && (x < fx || (x == fx && y < fy)))) {
                    minDist = d;
                    fx = x; fy = y;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 1) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
        }

        if (fx == -1) return null;
        return new int[]{fx, fy, minDist};
    }

    static int bfs(int x, int y, int ex, int ey) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], cd = cur[2];

            if (cx == ex && cy == ey) return cd;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 1) continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cd + 1});
                }
            }
        }

        return -1;
    }
}
