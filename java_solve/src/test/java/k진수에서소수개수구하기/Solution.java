package k진수에서소수개수구하기;

class Solution {
    public static void main(String[] args) {
        int n1 = 437674;
        int k1 = 3;
        int answer1 = 3;
        int result1 = new Solution().solution(n1, k1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 110011;
        int k2 = 10;
        int answer2 = 2;
        int result2 = new Solution().solution(n2, k2);
        PRINT_RESULT(2, result2, answer2);
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

    public int solution(int n, int k) {
        int answer = -1;
        return answer;
    }
}