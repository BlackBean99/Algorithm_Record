package 전력망을둘로나누기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int answer1 = 3;
        int result1 = new Solution().solution(n1, wires1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 4;
        int[][] wires2 = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int answer2 = 0;
        int result2 = new Solution().solution(n2, wires2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 7;
        int[][] wires3 = new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int answer3 = 1;
        int result3 = new Solution().solution(n3, wires3);
        PRINT_RESULT(3, result3, answer3);
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

    static int[][] arr;

    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        int a, b;
        for (int i = 0; i < wires.length; i++) {

            a = wires[i][0];
            b = wires[i][1];

            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        return answer;
    }

//        return answer;

        private int bfs(int n, int start){
            int[] visit = new int[n + 1];
            int cnt = 1;

            Queue<Integer> q = new LinkedList<>();
            q.offer(start);

            while (!q.isEmpty()) {
                int point = q.poll();
                visit[point] = 1;
                for (int i = 1; i < n + 1; i++) {
                    if (visit[i] == 1) continue;
                    if (arr[point][i] == 1) {
                        q.offer(i);
                        cnt++;
                    }
                }
            }
            // 하나 끊으면 cnt, n- cnt 로 나눠질 것이다.
            // 두 차이를 구하면 n-2cnt 이다.
            return (int) Math.abs(n - 2 * cnt);
        }
}



















