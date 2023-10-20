package 점찍기;

class Solution {
    public static void main(String[] args) {
        int k1 = 2;
        int d1 = 4;
        long answer1 = 6L;
        long result1 = new Solution().solution(k1, d1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 1;
        int d2 = 5;
        long answer2 = 26L;
        long result2 = new Solution().solution(k2, d2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, long result, long answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public long solution(int k, int d) {
        long answer = 0;
        return answer;
    }
}