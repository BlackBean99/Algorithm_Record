package 당구연습;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int m1 = 10;
        int n1 = 10;
        int startX1 = 3;
        int startY1 = 7;
        int[][] balls1 = new int[][]{{7, 7}, {2, 7}, {7, 3}};
        int[] answer1 = new int[]{52, 37, 116};
        int[] result1 = new Solution().solution(m1, n1, startX1, startY1, balls1);
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

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = {};

        /**
         * M이 가로 길이
         * n 이 세로길이
         *
         * */
        return answer;
    }
}