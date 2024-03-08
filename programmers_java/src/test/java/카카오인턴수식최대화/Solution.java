package 카카오인턴수식최대화;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        long answer1 = 60420L;
        long result1 = new Solution().solution(expression1);
        PRINT_RESULT(1, result1, answer1);

        String expression2 = "50*6-3*2";
        long answer2 = 300L;
        long result2 = new Solution().solution(expression2);
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

    static boolean[] check = new boolean[3];
    static List<Long> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();

    static char[] prior = {'+', '-', '*'};
    static long answer;

    static void dfs(int count, char[] perm) {
        if (count == 3) {
            List<Long> copyNums = new ArrayList<>(nums);
            List<Character> copyOps = new ArrayList<>(ops);

            for (int i = 0; i < perm.length; i++) {
                for (int j = 0; j < copyOps.size(); j++) {
                    if (perm[i] == copyOps.get(j)) {
                        Long result = calc(copyNums.remove(j), copyNums.remove(j), perm[i]);
                        copyNums.add(j, result);
                        copyOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(copyNums.get(0)));
        }
        for (int i = 0; i < 3; i++) {
            if (check[i]) continue;
            check[i] = true;
            perm[count] = prior[i];
            dfs(count + 1, perm);
            check[i] = false;
        }
    }

    private static Long calc(Long num1, Long num2, char op) {
        long num = 0;
        switch (op) {
            case '+':
                {
                    return num1 + num2;
                }
            case '-':
                {
                    return num1 - num2;
                }
            case '*':
                {
                    return num1 * num2;
                }
        }
        return num;
    }

    public long solution(String expression) {
        answer = 0;
        nums =
                Arrays.stream(expression.split("[\\+\\-\\*]"))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-'
                    || expression.charAt(i) == '+'
                    || expression.charAt(i) == '*') ops.add(expression.charAt(i));
        }
        dfs(0, new char[3]);
        return answer;
    }
}
