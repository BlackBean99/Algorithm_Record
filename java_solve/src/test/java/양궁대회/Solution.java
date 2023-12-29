package 양궁대회;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n1 = 5;
        int[] info1 = new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] answer1 = new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};
        int[] result1 = new Solution().solution(n1, info1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 1;
        int[] info2 = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] answer2 = new int[]{-1};
        int[] result2 = new Solution().solution(n2, info2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 9;
        int[] info3 = new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] answer3 = new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0};
        int[] result3 = new Solution().solution(n3, info3);
        PRINT_RESULT(3, result3, answer3);

        int n4 = 10;
        int[] info4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] answer4 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};
        int[] result4 = new Solution().solution(n4, info4);
        PRINT_RESULT(4, result4, answer4);
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

    public int[] solution(int n, int[] info) {
        int[] answer = {};
        return answer;
    }
}