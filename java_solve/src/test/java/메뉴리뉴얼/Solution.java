package 메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public static void main(String[] args) {
/*        String[] orders1 = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = new int[]{2, 3, 4};
        String[] answer1 = new String[]{"AC", "ACDE", "BCFG", "CDE"};
        String[] result1 = new Solution().solution(orders1, course1);
        PRINT_RESULT(1, result1, answer1);

        String[] orders2 = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = new int[]{2, 3, 5};
        String[] answer2 = new String[]{"ACD", "AD", "ADE", "CD", "XYZ"};
        String[] result2 = new Solution().solution(orders2, course2);
        PRINT_RESULT(2, result2, answer2);

        String[] orders3 = new String[]{"XYZ", "XWY", "WXA"};
        int[] course3 = new int[]{2, 3, 4};
        String[] answer3 = new String[]{"WX", "XY"};
        String[] result3 = new Solution().solution(orders3, course3);
        PRINT_RESULT(3, result3, answer3);*/
    }

    public static void PRINT_RESULT(int index, String[] result, String[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }
    static Map<String, Integer> map;

    public static void combination(String str, StringBuilder sb, int index, int cnt, int n) {
        // 종료 조건
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        // index부터 시작하여 조합을 구한다.
        for (int i = index; i <str.length(); i++) {
            sb.append(str.charAt(i));
            combination(str, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }


        public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for(int i =0;i<course.length;i++){
            // 6. HashMap으로 조합의 수를 카운팅.
            map = new HashMap<>();
            // 7. course의 경우에 따라 구한 조합들 중 가장 많이 주문된 횟수를 저장.
            int max = Integer.MIN_VALUE;
            // 8. 각 사람들의 조합을 구하기 위해 탐색.
            for(int j =0;j<orders.length;j++){
                // 9. 조합을 구하기 위해 문자열을 조작할 StringBuilder.
                StringBuilder sb = new StringBuilder();
                // 10. 코스의 개수 <= 각 문자열의 길이인 경우 조합을 구한다.
                if(course[i]<=orders[j].length())
                    // 11. 조합을 구하기 위한 메소드 호출
                    combination(orders[j],sb,0,0,course[i]);
            }
            for (Entry<String, Integer> entry : map.entrySet()) {
                max = Math.max(max, entry.getValue());
            }
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max >= 2 && entry.getValue() == max) {
                    answer.add(entry.getKey());
                }
            }
        }
        Collections.sort(answer);
        return answer;


    }
}