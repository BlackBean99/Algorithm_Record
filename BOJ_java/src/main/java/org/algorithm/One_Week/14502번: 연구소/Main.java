import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int answer = 0;
    static int safeArea = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) safeArea++;
            }
        }

        simulateWalls(0, 0);
        System.out.println(answer);
    }

    // idx부터 n*m까지 순회하며 벽 3개 세우기
    static void simulateWalls(int idx, int count){
        if(count == 3){
            answer = Math.max(answer, calculate());
            return;
        }

        for(int i = idx; i < n * m; i++){
            int x = i / m;
            int y = i % m;

            if(arr[x][y] == 0){
                arr[x][y] = 1;
                simulateWalls(i + 1, count + 1);
                arr[x][y] = 0;
            }
        }
    }

    // 바이러스 퍼뜨린 후 안전 영역 계산
    static int calculate(){
        int[][] cloned = new int[n][m];
        for(int i = 0; i < n; i++)
            cloned[i] = arr[i].clone();

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(cloned[i][j] == 2 && !visited[i][j]){
                    bfs(i, j, visited, cloned);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(cloned[i][j] == 0) count++;
            }
        }

        return count;
    }

    static void bfs(int x, int y, boolean[][] visited, int[][] cloned){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(isBound(nx, ny) && !visited[nx][ny] && cloned[nx][ny] == 0){
                    cloned[nx][ny] = 2;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    static boolean isBound(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}
