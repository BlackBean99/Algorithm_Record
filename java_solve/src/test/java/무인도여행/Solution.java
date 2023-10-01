package 무인도여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] maps1 = new String[]{"X591X", "X1X5X", "X231X", "1XXX1"};
        int[] answer1 = new int[]{1, 1, 27};
        int[] result1 = new Solution().solution(maps1);
        PRINT_RESULT(1, result1, answer1);

        String[] maps2 = new String[]{"XXX", "XXX", "XXX"};
        int[] answer2 = new int[]{-1};
        int[] result2 = new Solution().solution(maps2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }
    class Pos {
        int x, y;
        int level;
        Pos(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
        static char[][] map;
        static boolean[][] visited;
        static int[] dx = {-1,0,1,0};
        static int[] dy = {0,1,0,-1};

    public int bfs(int startX, int startY, int H, int W, int endX, int endY) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(startX, startY,0));
        visited[startX][startY] = true;
        while (!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;
            // 종료조건
            if (x == endX && y == endY) {
                return level;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= H || ny < 0 || ny >= W)
                    continue;
                if (visited[nx][ny] && map[nx][ny] != 'X') {
                    q.add(new Pos(nx,ny,level + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }
        public int solution(String[] maps) {
            int answer = 0;
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];
            Pos startPos = null;
            Pos leverPos = null;
            Pos endPos = null;
            for(int i = 0; i < maps.length; i++) {
                for(int j = 0; j < maps[i].length(); j++) {
                    if(maps[i].charAt(j) == 'S')
                        startPos = new Pos(i, j, 0);
                    if(maps[i].charAt(j) == 'L')
                        leverPos = new Pos(i, j, 0);
                    if(maps[i].charAt(j) == 'E')
                        endPos = new Pos(i, j, 0);
                    map[i][j] = maps[i].charAt(j);
                }
            }
            answer = bfs(startPos.x, startPos.y, maps.length, maps[0].length(), leverPos.x, leverPos.y);
            if(answer > -1)
            {
                visited = new boolean[map.length][map[0].length];

                int temp = bfs(leverPos.x, leverPos.y, maps.length, maps[0].length(), endPos.x, endPos.y);
                if(temp == -1)
                    answer = -1;
                else
                    answer += temp;
            }
            return answer;
        }
}

