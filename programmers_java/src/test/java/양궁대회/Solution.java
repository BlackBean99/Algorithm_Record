package 양궁대회;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n1 = 5;
        int[] info1 = new int[] {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] answer1 = new int[] {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};
        int[] result1 = new Solution().solution(n1, info1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 1;
        int[] info2 = new int[] {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] answer2 = new int[] {-1};
        int[] result2 = new Solution().solution(n2, info2);
        PRINT_RESULT(2, result2, answer2);

        int n3 = 9;
        int[] info3 = new int[] {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] answer3 = new int[] {1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0};
        int[] result3 = new Solution().solution(n3, info3);
        PRINT_RESULT(3, result3, answer3);

        int n4 = 10;
        int[] info4 = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] answer4 = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};
        int[] result4 = new Solution().solution(n4, info4);
        PRINT_RESULT(4, result4, answer4);
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

    private static int[] res = new int[11]; // 점수차가 최대일때 라이언이 쏜 화살배열
    private static int[] lion = {-1}; // 정답배열
    private static int max = Integer.MIN_VALUE; // 최대값

    public static int[] solution(int n, int[] info) {
        back(0, n, info); // 라이언이 쏜 화살에 대한 조합

        if (max == -1) { // 라이언이 어피치를 못 이길떄
            lion = new int[1];
            lion[0] = -1;
        }
        return lion;
    }

    public static void back(int depth, int n, int[] info) {
        // 화살 다 꽂았을때(종료조건)
        if (depth == n) {
            int diff = score(info); // 점수차 구하기
            if (max <= diff) { // 점수차 최대값 갱신
                max = diff;
                lion = res.clone();
            }
            return;
        }

        // res[i]<=info[i] -> i과녁에 라이언이 화살을 더 많이 맞추면 반복문 종료한다.
        for (int i = 0; i < info.length && res[i] <= info[i]; i++) {
            res[i] += 1;
            back(depth + 1, n, info);
            res[i] -= 1;
        }
    }

    // 점수차 구하기
    public static int score(int[] info) {
        int apeach = 0, lion = 0;
        for (int i = 0; i < res.length; i++) {
            if (info[i] == 0 && res[i] == 0) continue; // i원소에 둘다 0개 맞췄을땐 무시.
            if (info[i] >= res[i]) apeach += (10 - i);
            else lion += (10 - i);
        }

        int diff = lion - apeach;
        if (diff <= 0) return -1;
        return diff;
    }
}
