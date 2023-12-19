package 이진변환반복하기;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String s1 = "110010101001";
        int[] answer1 = new int[]{3, 8};
        int[] result1 = new Solution().solution(s1);
        PRINT_RESULT(1, result1, answer1);

        String s2 = "01110";
        int[] answer2 = new int[]{3, 3};
        int[] result2 = new Solution().solution(s2);
        PRINT_RESULT(2, result2, answer2);

        String s3 = "1111111";
        int[] answer3 = new int[]{4, 1};
        int[] result3 = new Solution().solution(s3);
        PRINT_RESULT(3, result3, answer3);
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

    public int[] solution(String s) {
        int[] answer = {};

        return answer;
    }
}