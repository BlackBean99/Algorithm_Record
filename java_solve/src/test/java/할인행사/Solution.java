package 할인행사;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] want1 = new String[]{"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = new int[]{3, 2, 2, 2, 1};
        String[] discount1 = new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer1 = 3;
        int result1 = new Solution().solution(want1, number1, discount1);
        PRINT_RESULT(1, result1, answer1);

        String[] want2 = new String[]{"apple"};
        int[] number2 = new int[]{10};
        String[] discount2 = new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        int answer2 = 0;
        int result2 = new Solution().solution(want2, number2, discount2);
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

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - days + 1; i++){
            Map<String, Integer> dMap = new HashMap<>();

            for(int j = 0; j < days; j++){
                dMap.put(discount[i + j], dMap.getOrDefault(discount[i + j], 0) + 1);
            }

            Boolean isIdentical = true;

            for(String key : map.keySet()){
                if(map.get(key) != dMap.get(key)){
                    isIdentical = false;
                    break;
                }
            }

            answer += isIdentical ? 1 : 0;
        }

        return answer;
    }
}