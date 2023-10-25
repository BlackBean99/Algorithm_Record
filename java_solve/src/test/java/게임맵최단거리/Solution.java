package 게임맵최단거리;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int[][] maps1 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int answer1 = 11;
        int result1 = new Solution().solution(maps1);
        PRINT_RESULT(1, result1, answer1);

        int[][] maps2 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        int answer2 = -1;
        int result2 = new Solution().solution(maps2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;


        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));

        while(!q.isEmpty()){
            Point current = q.poll();
            if(current.x == m-1 && current.y == n-1) return current.distance;
            for (int dir = 0; dir < 4; dir++) {
                int nextX = current.x + dx[dir];
                int nextY = current.y + dy[dir];
                if (0 <= nextX && nextX < m && 0 <= nextY && nextY < n && maps[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                    q.add(new Point(nextX, nextY, current.distance + 1));
                    visited[nextX][nextY] = 1;
                }
            }
        }

        return -1;
    }
    class Point{
        int x;
        int y;
        int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}