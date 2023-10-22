package 주차요금계산;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] fees1 = new int[]{180, 5000, 10, 600};
        String[] records1 = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer1 = new int[]{14600, 34400, 5000};
        int[] result1 = new Solution().solution(fees1, records1);
        PRINT_RESULT(1, result1, answer1);

        int[] fees2 = new int[]{120, 0, 60, 591};
        String[] records2 = new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        int[] answer2 = new int[]{0, 591};
        int[] result2 = new Solution().solution(fees2, records2);
        PRINT_RESULT(2, result2, answer2);

        int[] fees3 = new int[]{1, 461, 1, 10};
        String[] records3 = new String[]{"00:00 1234 IN"};
        int[] answer3 = new int[]{14841};
        int[] result3 = new Solution().solution(fees3, records3);
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

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        return answer;
    }
}