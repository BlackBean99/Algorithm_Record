import java.util.*;

class Solution {
    public int[][] visit;  // 방문 배열 선언
    public int[] oil;

    public int solution(int[][] land) {
        int answer = 0;
        int rows = land.length;
        int cols = land[0].length;

        // 방문 배열 초기화
        visit = new int[rows][cols]; 
        oil = new int[cols];

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (land[i][j] == 1 && visit[i][j] == 0) {
                    bfs(land, i, j);  
                }
            }
        }

        // 최대값 찾기
        for (int a : oil) {
            answer = Math.max(answer, a);
        }

        return answer;
    }

    private void bfs(int[][] map, int y, int x) {  
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();  // 🔥 `bfs`마다 새로운 `set` 사용
        q.offer(new int[]{y, x});
        visit[y][x] = 1;
        set.add(x);  // 첫 번째 위치 추가

        int size = 1;  
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cy = current[0], cx = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length 
                    && map[ny][nx] == 1 && visit[ny][nx] == 0) {
                    
                    visit[ny][nx] = 1;  // 🔥 방문 처리 추가
                    q.offer(new int[]{ny, nx});
                    set.add(nx);
                    size++;
                }
            }
        }

        // 같은 열에 있는 석유 덩어리 크기 업데이트
        for (Integer col : set) {
            oil[col] += size;
        }
    }
}
