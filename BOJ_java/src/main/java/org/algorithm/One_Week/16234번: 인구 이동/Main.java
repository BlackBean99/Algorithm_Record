import java.io.*;
import java.util.*;

public class Main {
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            visited = new boolean[n][n];
            boolean moved = false; // 오늘 하루 인구 이동 여부

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j); // 연합 구성

                        if (union.size() > 1) { // 실제로 국경이 열린 연합만 인구 재배치
                            int sum = 0;
                            for (int[] cell : union) {
                                sum += map[cell[0]][cell[1]];
                            }
                            int avg = sum / union.size();
                            for (int[] cell : union) {
                                map[cell[0]][cell[1]] = avg;
                            }
                            moved = true;
                        }
                    }
                }
            }

            if (!moved) break; // 더 이상 인구 이동 없음 → 종료
            answer++;
        }

        System.out.println(answer);
    }

    static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> union = new ArrayList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;
        union.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if (diff >= l && diff <= r) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                }
            }
        }
        return union;
    }
}
