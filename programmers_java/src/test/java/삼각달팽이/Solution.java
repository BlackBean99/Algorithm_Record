package 삼각달팽이;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n1 = 4;
        int[] answer1 = new int[] {1, 2, 9, 3, 10, 8, 4, 5, 6, 7};
        int[] result1 = new Solution().solution(n1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 5;
        int[] answer2 = new int[] {1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9};
        int[] result2 = new Solution().solution(n2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 6;
        int[] answer3 =
                new int[] {
                    1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11
                };
        int[] result3 = new Solution().solution(n3);
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

    public int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    break;
                }
                answer[k++] = matrix[i][j];
            }
        }
        return answer;
    }
}
