package 귤고르기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = new int[] {1, 3, 2, 5, 4, 5, 2, 3};
        int answer1 = 3;
        int result1 = new Solution().solution(k1, tangerine1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 4;
        int[] tangerine2 = new int[] {1, 3, 2, 5, 4, 5, 2, 3};
        int answer2 = 2;
        int result2 = new Solution().solution(k2, tangerine2);
        PRINT_RESULT(2, result2, answer2);

        int k3 = 2;
        int[] tangerine3 = new int[] {1, 1, 1, 1, 2, 2, 2, 3};
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

    Map<Integer, Integer> map = new TreeMap<>();

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        // 개수기준으로 정렬
        List<Integer> keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, new customComparator());

        // 정렬된 key리스트에서 값을 하나씩 가져와 k에 빼줌
        for (Integer e : keylist) {
            if (k <= 0) break;
            answer++;
            k -= map.get(e);
        }
        return answer;
    }

    public class customComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return map.get(o2).compareTo(map.get(o1));
        }
    }
}
