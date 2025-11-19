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

            rotate(refresh[0],0);
            rotate(refresh[1],1);
        }
        System.out.println(sumDust());
        
    }

    static void rotate(int[] refresh, int dir){
        int cx = refresh[0];
        int cy = refresh[1];
        int nx = refresh[0];
        int ny = refresh[1];
        // 한칸씩 땅겨오는 것이다.
        for(int i = 0; i < 4; i++){
            while(nx >= 0 && nx < r && ny >= 0 && ny < c){
                if(dir == 0){
                    nx = cx + dx1[i];
                    ny = cy + dy1[i];
                } else {
                    nx = cx + dx2[i];
                    ny = cy + dy2[i];
                }
                if(dust[cx][cy] == -1){
                    continue;
                } else {
                    if(nx >= 0 && nx < r && ny >= 0 && ny < c){
                        dust[cx][cy] = dust[nx][ny];
                        cx = nx;
                        cy = ny;
                    }
                }
                
            }
        }
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
        for(int[] location: locations){
            int spreadCnt = 0;
            for(int i = 0; i < 4; i++){
                int nx = location[0] + dx[i];
                int ny = location[1] + dy1[i];
                if(nx >= 0 && nx < r&& ny >= 0 && ny < c){
                    spreadCnt++;
                    dust[nx][ny] = dust[location[0]][location[1]] / 5;
                }
            }
            dust[location[0]][location[1]] -= dust[location[0]][location[1]]/5*spreadCnt;
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