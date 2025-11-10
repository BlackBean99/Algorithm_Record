import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        answer = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true;
                dfs(i,j,1,map[i][j]);
                visited[i][j] = false;
                checkT(i,j);
            }
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int depth, int sum){
        if(depth == 4){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // DFS로 4칸 연결 (ㅗ 제외)
    static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;  // 백트래킹 ⭐
            }
        }
    }
    
    // ㅗ, ㅜ, ㅏ, ㅓ 모양 별도 체크
    static void checkT(int x, int y) {
        // ㅗ 모양 4가지 회전
        int[][][] tShapes = {
            {{0,0}, {0,1}, {0,2}, {1,1}},  // ㅗ
            {{0,0}, {1,0}, {2,0}, {1,1}},  // ㅏ
            {{0,1}, {1,0}, {1,1}, {1,2}},  // ㅜ
            {{0,1}, {1,0}, {1,1}, {2,1}}   // ㅓ
        };
        
        for(int[][] shape : tShapes) {
            int sum = 0;
            boolean valid = true;
            
            for(int[] pos : shape) {
                int nx = x + pos[0];
                int ny = y + pos[1];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    valid = false;
                    break;
                }
                sum += map[nx][ny];
            }
            
            if(valid) {
                answer = Math.max(answer, sum);
            }
        }
        // mask state , K번째 현재 도달했음
        new int[1 << K][K]
        dp[0][0] = 0;
        
    }
}