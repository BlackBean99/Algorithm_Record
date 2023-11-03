package 이모티콘할인행사;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] users1 = new int[][]{{40, 10000}, {25, 10000}};
        int[] emoticons1 = new int[]{7000, 9000};
        int[] answer1 = new int[]{1, 5400};
        int[] result1 = new Solution().solution(users1, emoticons1);
        PRINT_RESULT(1, result1, answer1);

        int[][] users2 = new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = new int[]{1300, 1500, 1600, 4900};
        int[] answer2 = new int[]{4, 13860};
        int[] result2 = new Solution().solution(users2, emoticons2);
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

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        return answer;
    }
}