package org.algorithm.BFS.안전영역;


import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int answer = 0;
        map = new int[n][n];
        visited = new boolean[n][n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(map[i][j], min);
                max = Math.max(map[i][j], max);
            }
        }

        for(int i = max; i >= min; i--){
            int temp = bfsStart(i);
            answer = Math.max(temp, answer);
            for (boolean[] row : visited) {
                Arrays.fill(row, false);
            }
            
        }
        System.out.println(answer);
    }
            
    private static int bfsStart(int height) {
        int areaCount = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j ++){
                if(!visited[i][j] && map[i][j] > height){
                    areaCount += bfs(i,j, height);
                } 
            }
        }
        return areaCount;
    }
                
    private static int bfs(int startX, int startY, int height) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] > height){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        return 1;

    }
}
