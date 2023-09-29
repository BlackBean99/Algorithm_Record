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


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static List<Integer> solution(String[] maps){
        List<Integer> answer = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }

        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    answer.add(bfs(i, j));
                }
            }
        }

        if(answer.size() == 0){
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }

    public static int bfs(int x, int y){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy]-'0';
            for(int i=0;i<4;i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                    continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}