package 튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] answer1 = new int[]{2, 1, 3, 4};
        int[] result1 = new Solution().solution(s1);
        PRINT_RESULT(1, result1, answer1);

        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] answer2 = new int[]{2, 1, 3, 4};
        int[] result2 = new Solution().solution(s2);
        PRINT_RESULT(2, result2, answer2);

        String s3 = "{{20,111},{111}}";
        int[] answer3 = new int[]{111, 20};
        int[] result3 = new Solution().solution(s3);
        PRINT_RESULT(3, result3, answer3);

        String s4 = "{{123}}";
        int[] answer4 = new int[]{123};
        int[] result4 = new Solution().solution(s4);
        PRINT_RESULT(4, result4, answer4);

        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer5 = new int[]{3, 2, 4, 1};
        int[] result5 = new Solution().solution(s5);
        PRINT_RESULT(5, result5, answer5);
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

    public int[] solution(String s) {

        String substring1 = s.substring(2, s.length() - 1);
        String substring2 = substring1.substring(0, substring1.length()-1);
        String[] split = substring2.split("},\\{");
        Map<Integer, Boolean> map = new java.util.HashMap<>();
        List<List<Integer>> list = new LinkedList<>();
        int[] answer = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(",");
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < split1.length; j++) {
                tmp.add(Integer.parseInt(split1[j]));
            }
            list.add(tmp);
        }
        list.sort((o1, o2) -> o1.size() - o2.size());
        for (List<Integer> elem: list) {
            for (Integer integer : elem) {
                if (map.get(integer) == null){
                    map.put(integer, true);
                    answer[elem.size() - 1] = integer;
                    break;
                } else{
                    map.put(integer, true);
                }
            }
        }


        return answer;
    }
}