package 롤케이크자르기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int[] topping1 = new int[] {1, 2, 1, 3, 1, 4, 1, 2};
        int answer1 = 2;
        int result1 = new Solution().solution(topping1);
        PRINT_RESULT(1, result1, answer1);

        int[] topping2 = new int[] {1, 2, 3, 1, 4};
        int answer2 = 0;
        int result2 = new Solution().solution(topping2);
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

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> a = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int t : topping) {
            if (a.containsKey(t)) {
                a.put(t, a.get(t) + 1);
            } else {
                a.put(t, 1);
            }
        }

        for (int t : topping) {
            a.put(t, a.get(t) - 1);
            set.add(t);
            if (a.get(t) == 0) {
                a.remove(t);
            }
            if (a.size() == set.size()) {
                answer++;
            }
        }
        return answer;
    }
}
