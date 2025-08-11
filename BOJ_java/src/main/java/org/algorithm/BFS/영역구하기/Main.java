package org.algorithm.BFS.영역구하기;


import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int m,n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i = 0; i < k; i++){
            String[] arr = br.readLine().split(" ");
            int cx = Integer.parseInt(arr[0]);
            int cy = Integer.parseInt(arr[1]);
            int nx = Integer.parseInt(arr[2]);
            int ny = Integer.parseInt(arr[3]);
            for(int x = cx; x < nx; x++){
                for(int y = cy; y < ny; y++){
                    map[y][x] = 1;
                    visited[y][x] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    list.add(bfs(i,j));
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for(int value: list){
            System.out.print(value + " ");
        }
    }

    private static int bfs(int x, int y){
        visited[x][y] = true;
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    area++;
                    queue.offer(new int[]{nx,ny});
                }

            }
        }
        return area;
    }
}