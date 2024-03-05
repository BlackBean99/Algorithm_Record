package 카펫;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;
        int[] answer1 = new int[] {4, 3};
        int[] result1 = new Solution().solution(brown1, yellow1);
        PRINT_RESULT(1, result1, answer1);

        int brown2 = 8;
        int yellow2 = 1;
        int[] answer2 = new int[] {3, 3};
        int[] result2 = new Solution().solution(brown2, yellow2);
        PRINT_RESULT(2, result2, answer2);

        int brown3 = 24;
        int yellow3 = 24;
        int[] answer3 = new int[] {8, 6};
        int[] result3 = new Solution().solution(brown3, yellow3);
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

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;
        int a, b;
        for (int i = 3; i <= total / 2; i++) {
            if (total % i == 0) {
                b = i;
                a = total / i;
                //                일 경우에 yellow 가 a,b 사이즈에 들어가냐.
                if (a >= b) {
                    if (isPossible(a, b, yellow)) {
                        answer[0] = a;
                        answer[1] = b;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPossible(int width, int height, int yellow) {
        int newWidth = width - 2;
        int newHeight = height - 2;
        int a, b;
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                b = i;
                a = yellow / i;
                //                일 경우에 yellow 가 a,b 사이즈에 들어가냐.
                if (a <= newWidth && b <= newHeight) {
                    return true;
                }
            }
        }
        return false;
    }
}
