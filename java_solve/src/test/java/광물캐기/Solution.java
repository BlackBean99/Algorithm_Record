package 광물캐기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * main, PRINT_RESULT 는 테스트 케이스 실행 및 결과 확인을 위한 함수입니다.
 * [답안지 복사] 기능을 사용하는 경우 해당 함수들을 제외하며, 답안에 필요한 코드만 복사됩니다.
 * 테스트 케이스 추가 등 함수 내부 변경은 가능하나, 함수 이름 변경시 [답안지 복사] 기능이 제대로 동작하지 않습니다.
 *
 * 또한, 기본 설정으로 [답안지 복사] 사용시 해당 주석과 작성하신 주석을 제외하여 복사됩니다.
 * [주석 복사] 여부는 설정을 통해 변경할 수 있습니다.
 *
 * [도움말 주석] 옵션은 설정을 통해 제거할 수 있습니다.
 *
 * - [답안지 복사]
 *   코드 - 답안지 복사 (기본 단축키 cmd + shift + w)
 *
 * - [도움말 주석]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 도움말 주석
 *
 * - [주석 복사]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 주석 복사
 *
 * GitHub: https://github.com/azqazq195/programmers_helper
 */
class Solution {
    public static void main(String[] args) {
        int[] picks1 = new int[]{1, 3, 2};
        String[] minerals1 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int answer1 = 12;
        int result1 = new Solution().solution(picks1, minerals1);
        PRINT_RESULT(1, result1, answer1);

        int[] picks2 = new int[]{0, 1, 1};
        String[] minerals2 = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        int answer2 = 50;
        int result2 = new Solution().solution(picks2, minerals2);
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


    static class Mineral {
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }

    static int[][] scoreBoard;
    static List<Mineral> list;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        // 전체 곡괭이 수
        int totalPicks = Arrays.stream(picks).sum();
        list = new ArrayList<>();
        // list 채우기
        for (int i = 0; i < minerals.length; i+=5) {
            if (totalPicks == 0) break;
            int dia = 0, iron = 0, stone = 0;
            // 5개 블럭 단위로 저장
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                String mineral = minerals[j];
                int val = mineral.equals("iron") ? 1 :
                        mineral.equals("stone") ? 2 : 0;
                // dia로 캤을 경우 피로도
                dia += scoreBoard[0][val];
                iron += scoreBoard[1][val];
                stone += scoreBoard[2][val];
            }
            list.add(new Mineral(dia, iron, stone));
            totalPicks--;
        }
        Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));
        for (Mineral m : list) {
            if(picks[0] > 0){
                answer += m.diamond;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += m.iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += m.stone;
                picks[2]--;
            }
    }
        return answer;
    }
}