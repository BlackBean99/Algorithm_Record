import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];

        int startX = 0, startY = 0, leverX = 0, leverY = 0, endX = 0, endY = 0;

        // 맵 초기화 및 위치 찾기
        for (int i = 0; i < n; i++) {
            char[] row = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // BFS를 이용하여 최단 거리 탐색
        int toLever = bfs(map, startX, startY, leverX, leverY);
        int toExit = bfs(map, leverX, leverY, endX, endY);

        if (toLever == -1 || toExit == -1) return -1;
        return toLever + toExit;
    }
    private int bfs(char[][] map, int startX, int startY, int targetX, int targetY){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        int n = map.length;
        int m = map[0].length;
        
        int[][] distance = new int[n][m];
        for(int i = 0; i < distance.length; i++) Arrays.fill(distance[i],-1);
        distance[startX][startY] = 0;
        
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int i = 0; i < 4; i ++){            
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];
                if(0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] != 'X' && distance[nx][ny] == -1){
                    q.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[current[0]][current[1]] + 1;
                }
            }
        }
        return distance[targetX][targetY];
    }
}
