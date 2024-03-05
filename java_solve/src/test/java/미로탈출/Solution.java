package 미로탈출;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        String[] maps1 = new String[] {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int answer1 = 16;
        int result1 = new Solution().solution(maps1);
        PRINT_RESULT(1, result1, answer1);

        String[] maps2 = new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
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

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int dfs(Point start, Point end, String[] maps, int count) {
        Queue<Point> q = new LinkedList<Point>();
        q.offer(start);
        //                if(maps[i].charAt(j) != 'O')
        //                    continue;
        while (!q.isEmpty()) {
            Point current = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.x + dx[dir];
                if (0 <= nx && nx < maps.length && 0 <= ny && ny < maps[0].length()) {
                    if (maps[nx].charAt(ny) == 'O') {
                        q.offer(new Point(nx, ny));
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int solution(String[] maps) {
        int answer = 0;
        int[][] distance = new int[maps.length][maps[0].length()];
        Point start = null;
        Point end = null;
        Point lever = null;

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    start = new Point(i, j);
                } else if (maps[i].charAt(j) == 'E') {
                    end = new Point(i, j);
                } else if (maps[i].charAt(j) == 'L') {
                    lever = new Point(i, j);
                }
            }
        }
        int depth = dfs(start, lever, maps, 0);
        answer = depth + dfs(lever, end, maps, depth);
        return answer;
    }
}
