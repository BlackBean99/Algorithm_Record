package 테이블해시함수;

class Solution {
    public static void main(String[] args) {
        int[][] data1 = new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col1 = 2;
        int row_begin1 = 2;
        int row_end1 = 3;
        int answer1 = 4;
        int result1 = new Solution().solution(data1, col1, row_begin1, row_end1);
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

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        return answer;
    }
}