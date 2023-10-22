package 두큐합같게만들기;

class Solution {
    public static void main(String[] args) {
        int[] queue11 = new int[]{3, 2, 7, 2};
        int[] queue21 = new int[]{4, 6, 5, 1};
        int answer1 = 2;
        int result1 = new Solution().solution(queue11, queue21);
        PRINT_RESULT(1, result1, answer1);

        int[] queue12 = new int[]{1, 2, 1, 2};
        int[] queue22 = new int[]{1, 10, 1, 2};
        int answer2 = 7;
        int result2 = new Solution().solution(queue12, queue22);
        PRINT_RESULT(2, result2, answer2);

        int[] queue13 = new int[]{1, 1};
        int[] queue23 = new int[]{1, 5};
        int answer3 = -1;
        int result3 = new Solution().solution(queue13, queue23);
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

    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        return answer;
    }
}