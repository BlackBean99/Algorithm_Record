import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = new int[]{1,0,-1,0};

    static int[] dx1 = new int[]{0,1,0,-1};
    static int[] dy1 = new int[]{1,0,-1,0};

    static int[] dx2 = new int[]{0,1,0,-1};
    static int[] dy2 = new int[]{-1,0,1,0};
    static int r;
    static int c;
    static int t;
    static int[][] dust;
    static int[][] refresh;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        dust = new int[r][c];
        refresh = new int[2][2];
        int refreshCount = 0;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                dust[i][j] = Integer.parseInt(st.nextToken());
                if(dust[i][j] == -1){
                    refresh[refreshCount] = new int[]{i,j};
                    refreshCount++;
                }
            }
        }
        for(int i = 0; i < t; i++){
            // 확산
            List<int[]> locations = findSpreadable();
            spread(locations);
            // Moving 시계 반시계
            rotate();
        }
        System.out.println(sumDust());
        
    }

    static void rotate(){
        // 공기청정기 윗부분 반시계 방향 밀기
        int top = refresh[0][0];
        for(int i = top-2; i >= 0; i--){
            dust[i][0] = dust[i+1][0];
        }
        for(int i = 1; i < r; i++){
            dust[0][i-1] = dust[0][i];
        }

        int bottom = refresh[1][0];
    }

    static int sumDust(){
        int sum = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(dust[i][j] > 0){
                    sum += dust[i][j];
                }
            }
        }
        return sum;
    }

    static void spread(List<int[]> locations){
        int[][] tmp = new int[r][c];
        for(int i = 0; i < r; i++){
            Arrays.fill(tmp[i].0);
        }

        for(int[] location: locations){
            int spreadCnt = 0;
            for(int i = 0; i < 4; i++){
                int nx = location[0] + dx[i];
                int ny = location[1] + dy1[i];
                if(nx >= 0 && nx < r&& ny >= 0 && ny < c){
                    spreadCnt++;
                    tmp[nx][ny] += dust[location[0]][location[1]] / 5;
                }
            }
            tmp[location[0]][location[1]] -= dust[location[0]][location[1]]/5*spreadCnt;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(dust[i][j] != -1){
                        dust[i][j] += tmp[i][j];
                    }
                }
            }
        }
    }

    static List<int[]> findSpreadable(){
        List<int[]> locations = new ArrayList<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(dust[i][j] > 0){
                    locations.add(new int[]{i,j});
                }
            }
        }
        return locations;
    }
}