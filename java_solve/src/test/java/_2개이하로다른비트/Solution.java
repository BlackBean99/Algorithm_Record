package _2개이하로다른비트;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        long[] numbers1 = new long[] {2L, 7L};
        long[] answer1 = new long[] {3L, 11L};
        long[] result1 = new Solution().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, long[] result, long[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                String s = Long.toString(numbers[i], 2);
                int zeroIdx = s.lastIndexOf("0");
                //
                if (zeroIdx != -1) {
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx + 2, s.length());
                    answer[i] = Long.parseLong(s, 2);
                }
                // 0도 섞인 경우
                else {
                    s = "10" + s.substring(1, s.length());
                    answer[i] = Long.parseLong(s, 2);
                }
            }
        }

        return answer;
    }
}
