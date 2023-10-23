package 혼자놀기의달인;

class Solution {
    public static void main(String[] args) {
        int[] cards1 = new int[]{8, 6, 3, 7, 2, 5, 1, 4};
        int answer1 = 12;
        int result1 = new Solution().solution(cards1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int[] cards) {
        int answer = 0;
        return answer;
    }
}