import java.util.*;
import java.io.*;

public class Main{
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt; // 벽을 부순 개수
    
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    
        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String[] k = br.readLine().split("");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(k[j-1]);
            }
        }
        int answer = bfs(1,1);
        System.out.println(answer);
    }
    public static int bfs(int x, int y){
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(x,y,0));
        boolean[][] visit = new boolean[n+1][m+1];
        visit[x][y] = true;
        while(!q.isEmpty()){
            Point p = q.poll();
            if(p.x == n && p.y == m){
                return p.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx < 1 || ny < 1 || nx > n || ny > m) continue;
                if(!visit[nx][ny] && map[nx][ny] == 0) {
                    visit[nx][ny] = true;
                    q.offer(new Point(nx,ny, p.cnt));
                }
                if(!visit[nx][ny] && map[nx][ny] == 1){
                    visit[nx][ny] = true;
                    q.offer(new Point(nx,ny, p.cnt + 1));
                }
                
            }
        }
        return 0;
    }
}