package 숫자카드나누기;

class Solution {
    public static void main(String[] args) {
        int[] arrayA1 = new int[]{10, 17};
        int[] arrayB1 = new int[]{5, 20};
        int answer1 = 0;
        int result1 = new Solution().solution(arrayA1, arrayB1);
        PRINT_RESULT(1, result1, answer1);

        int[] arrayA2 = new int[]{10, 20};
        int[] arrayB2 = new int[]{5, 17};
        int answer2 = 10;
        int result2 = new Solution().solution(arrayA2, arrayB2);
        PRINT_RESULT(2, result2, answer2);

        int[] arrayA3 = new int[]{14, 35, 119};
        int[] arrayB3 = new int[]{18, 30, 102};
        int answer3 = 7;
        int result3 = new Solution().solution(arrayA3, arrayB3);
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

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        return answer;
    }
}