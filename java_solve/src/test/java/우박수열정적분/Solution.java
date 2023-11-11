package 우박수열정적분;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int k1 = 5;
        int[][] ranges1 = new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        double[] answer1 = new double[]{33.0, 31.5, 0.0, -1.0};
        double[] result1 = new Solution().solution(k1, ranges1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 3;
        int[][] ranges2 = new int[][]{{0, 0}, {1, -2}, {3, -3}};
        double[] answer2 = new double[]{47.0, 36.0, 12.0};
        double[] result2 = new Solution().solution(k2, ranges2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, double[] result, double[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        return answer;
    }
}