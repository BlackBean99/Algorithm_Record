package PCCP기출문제2번석유시추;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int[][] land1 = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        int answer1 = 9;
        int result1 = new Solution().solution(land1);
        PRINT_RESULT(1, result1, answer1);

        int[][] land2 = new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
        int answer2 = 16;
        int result2 = new Solution().solution(land2);
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

    public int solution(int[][] land) {
//        int answer = 0;
        List<Integer> answer = new LinkedList<>();

        for (int j = 0; j < land[0].length; j++) {
            int sum = 0;
            int temp = 0;
            for (int i = 0; i < land.length; i++) {
                boolean[][] visited = new boolean[land.length][land[0].length];
                int process = process(land, i, j, visited, 0);
                if(temp != process){
                    sum += process;
                }
                temp = process;
            }
            answer.add(sum);
        }
        int max = 0;
        for (int value: answer){
            max = Math.max(value, max);
        }
        return max;
    }
    int process(int[][] land, int x, int y, boolean[][] visited, int cnt){
        if(x < 0 || y < 0 || x >= land.length || y >= land[0].length || visited[x][y] || land[x][y] == 0){
            return cnt;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x,y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int i = pair.x;
            int j = pair.y;
            if(i < 0 || j < 0 || i >= land.length || j >= land[0].length || visited[i][j] || land[i][j] == 0){
                continue;
            }
            visited[i][j] = true;
            cnt++;
            queue.add(new Pair(i+1,j));
            queue.add(new Pair(i-1,j));
            queue.add(new Pair(i,j+1));
            queue.add(new Pair(i,j-1));
        }
        return cnt;
    }
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}