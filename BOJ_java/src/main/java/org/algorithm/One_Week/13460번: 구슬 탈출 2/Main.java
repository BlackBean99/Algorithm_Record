import java.io.*;
import java.util.*;

public class Main {

    static class Pos {
        int rx, ry, bx, by, depth;
        Pos(int rx, int ry, int bx, int by, int depth){
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.depth = depth;
        }
    }

    static int n, m;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, 0, -1, 0};   // down, right, up, left
    static int[] dy = {0, 1, 0, -1};

    static int rx, ry, bx, by, ox, oy;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = line.charAt(j);
                if(map[i][j]=='R'){ rx=i; ry=j; }
                if(map[i][j]=='B'){ bx=i; by=j; }
                if(map[i][j]=='O'){ ox=i; oy=j; }
            }
        }

        visited = new boolean[n][m][n][m];
        System.out.println(bfs());
    }

    static int bfs() {
        // Queue int[] 선언
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(rx,ry,bx,by,0));
        visited[rx][ry][bx][by] = true;
        // while Q
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.depth > 10){
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int[] r = move(cur.rx, cur.ry, i);
                int[] b = move(cur.bx, cur.by, i);
                if(r[0] == b[0] && r[1] == b[1]){
                    
                }
            }
        }
        
        // base condition -> 10 > 면 answwer = -1 return
        // for 4 -> 
        // Nx, ny 선언 moving ()
        // 겹치면, 조정
        // 방문처리,q 추가
        // 
    }
    // static int bfs(){

    //     Queue<Pos> q = new LinkedList<>();
    //     q.add(new Pos(rx, ry, bx, by, 0));
    //     visited[rx][ry][bx][by] = true;

    //     while(!q.isEmpty()){

    //         Pos cur = q.poll();
    //         if(cur.depth >= 10) return -1;

    //         for(int dir=0; dir<4; dir++){
    //             int[] r = move(cur.rx, cur.ry, dir);
    //             int[] b = move(cur.bx, cur.by, dir);

    //             int nrx = r[0], nry = r[1];
    //             int nbx = b[0], nby = b[1];

    //             boolean redHole = r[2] == 1;
    //             boolean blueHole = b[2] == 1;

    //             if(blueHole) continue;         // 실패
    //             if(redHole && !blueHole)       // 성공
    //                 return cur.depth + 1;

    //             // 둘이 겹치면
    //             if(nrx==nbx && nry==nby){
    //                 int rDist = Math.abs(nrx - cur.rx) + Math.abs(nry - cur.ry);
    //                 int bDist = Math.abs(nbx - cur.bx) + Math.abs(nby - cur.by);

    //                 // 더 멀리서 온 애가 한 칸 뒤로 감
    //                 if(rDist > bDist){
    //                     nrx -= dx[dir];
    //                     nry -= dy[dir];
    //                 } else {
    //                     nbx -= dx[dir];
    //                     nby -= dy[dir];
    //                 }
    //             }

    //             if(!visited[nrx][nry][nbx][nby]){
    //                 visited[nrx][nry][nbx][nby] = true;
    //                 q.add(new Pos(nrx,nry,nbx,nby,cur.depth+1));
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // [0] x, [1] y, [2] isHole
    static int[] move(int x, int y, int dir){
        int nx = x;
        int ny = y;

        while(true){
            nx += dx[dir];
            ny += dy[dir];

            if(map[nx][ny] == '#'){
                nx -= dx[dir];
                ny -= dy[dir];
                return new int[]{nx, ny, 0};
            }
            if(map[nx][ny] == 'O'){
                return new int[]{nx, ny, 1};
            }
        }
    }
}
