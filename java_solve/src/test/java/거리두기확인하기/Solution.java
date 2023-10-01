package 거리두기확인하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.w3c.dom.html.HTMLLinkElement;

class Solution {
    public static void main(String[] args) {
        String[][] places1 = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer1 = new int[]{1, 0, 1, 1, 1};
        int[] result1 = new Solution().solution(places1);
        PRINT_RESULT(1, result1, answer1);
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

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];

            boolean isOk = true;
            for (int r = 0; r < 5 && isOk; r++) {
                for (int c = 0; c < 5 && isOk; c++) {
                    if (p[r].charAt(c) == 'P') {
                        if (!bfs(r, c, p))
                            isOk = false;
                    }
                }
            }
            answer[i] = isOk ? 1 : 0;
        }

        return answer;
    }

    private static boolean bfs(int x, int y, String[] p) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            // 초기화
            int[] current = queue.poll();
            // 종료조건

            // 순회
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // 원래 자리는 검사 안한다.
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                if (distance <= 2 && p[nx].charAt(ny) == 'P')
                    return false;
                else if (p[nx].charAt(ny) == 'O')
                    queue.offer(new int[]{nx, ny});
            }
        }
        return true;
    }
}