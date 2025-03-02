package org.algorithm.BFS.알파벳;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
    static int[] dy = {0, 1, 0, -1};
    static int maxMove = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // DFS 시작 (0,0)에서 출발하며 첫 알파벳 방문 처리
        

        System.out.println(dfs());
    }

    private static int dfs() {
        Queue<State> queue = new LinkedList<>();
        Set<Character> startSet = new HashSet<>();
        startSet.add(board[0][0]);
        queue.offer(new State(0,0,startSet, 1));

        while(!queue.isEmpty()){
            State now = queue.poll();

            maxMove = Math.max(maxMove, now.depth);
            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                Set visited = now.visited;
                if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                    if(!visited.contains(board[nx][ny])){
                        Set<Character> newSet = new HashSet<>(now.visited);
                        newSet.add(board[nx][ny]);
                        queue.offer(new State(nx,ny,newSet,now.depth + 1));
                    }
                }
            }
        }
        return maxMove;
    }

    static class State{
        int x,y, depth;
        Set<Character> visited;

        public State(int x, int y, Set<Character> visited, int depth){
            this.x = x;
            this.y = y;
            this.visited = visited;
            this.depth = depth;
        }
    }
    // private static void dfs(int x, int y, int depth) {
    //     maxMove = Math.max(maxMove, depth);
    //     visited[board[x][y] - 'A'] = true; // 현재 알파벳 방문 처리

    //     for (int i = 0; i < 4; i++) {
    //         int nx = x + dx[i];
    //         int ny = y + dy[i];

    //         // 범위 내에 있고, 아직 방문하지 않은 알파벳이면 이동
    //         if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A']) {
    //             dfs(nx, ny, depth + 1);
    //         }
    //     }

    //     // 백트래킹 (다른 경로 탐색을 위해 방문 해제)
    //     visited[board[x][y] - 'A'] = false;
    // }
}
