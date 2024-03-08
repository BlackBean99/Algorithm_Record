package 디펜스게임;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int n1 = 7;
        int k1 = 3;
        int[] enemy1 = new int[] {4, 3, 2, 1};
        int answer1 = 5;
        int result1 = new Solution().solution(n1, k1, enemy1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 2;
        int k2 = 4;
        int[] enemy2 = new int[] {3, 3, 3, 3};
        int answer2 = 4;
        int result2 = new Solution().solution(n2, k2, enemy2);
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

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        // 1. 숫자 조합
        //        Arrays.sort(enemy, (a, b) -> b - a);
        comb1(enemy, new int[4], new boolean[n], 0, 3);
        // 2. 숫자 순열

        return answer;
    }

    static void comb1(int[] arr, int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                comb1(arr, output, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    static Map<String, Integer> map = new HashMap<>();

    static void strComb(String str, StringBuilder sb, int index, int cnt, int n) {
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
    }
}
