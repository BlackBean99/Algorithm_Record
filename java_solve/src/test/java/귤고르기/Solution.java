package 귤고르기;

class Solution {
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int answer1 = 3;
        int result1 = new Solution().solution(k1, tangerine1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 4;
        int[] tangerine2 = new int[]{1, 3, 2, 5, 4, 5, 2, 3};
        int answer2 = 2;
        int result2 = new Solution().solution(k2, tangerine2);
        PRINT_RESULT(2, result2, answer2);

        int k3 = 2;
        int[] tangerine3 = new int[]{1, 1, 1, 1, 2, 2, 2, 3};
        int answer3 = 1;
        int result3 = new Solution().solution(k3, tangerine3);
        PRINT_RESULT(3, result3, answer3);
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

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        return answer;
    }
}