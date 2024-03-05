package 도넛과막대그래프;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[][] edges1 = new int[][] {{2, 3}, {4, 3}, {1, 1}, {2, 1}};
        int[] answer1 = new int[] {2, 1, 1, 0};
        int[] result1 = new Solution().solution(edges1);
        PRINT_RESULT(1, result1, answer1);

        int[][] edges2 =
                new int[][] {
                    {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11},
                    {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
                };
        int[] answer2 = new int[] {4, 0, 1, 2};
        int[] result2 = new Solution().solution(edges2);
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

    public int[] solution(int[][] edges) {
        int[] answer = {};
        return answer;
    }
}
