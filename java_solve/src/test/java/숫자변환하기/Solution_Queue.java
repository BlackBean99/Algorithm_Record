package 숫자변환하기;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
class Solution_Queue {
    public static void main(String[] args) {
        int x1 = 10;
        int y1 = 40;
        int n1 = 5;
        int answer1 = 2;
        int result1 = new Solution_Queue().solution(x1, y1, n1);
        PRINT_RESULT(1, result1, answer1);

        int x2 = 10;
        int y2 = 40;
        int n2 = 30;
        int answer2 = 1;
        int result2 = new Solution_Queue().solution(x2, y2, n2);
        PRINT_RESULT(2, result2, answer2);

        int x3 = 2;
        int y3 = 5;
        int n3 = 4;
        int answer3 = -1;
        int result3 = new Solution_Queue().solution(x3, y3, n3);
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

    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> visit = new HashMap<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int num = q.poll();
            int cnt = visit.getOrDefault(num,0);
            if(num == y) return cnt;
            if (num + n <= y && !visit.containsKey(num + n)) {
                q.offer(num + n);
                visit.put(num + n, cnt + 1);
            }
            if (num * 2 <= y && !visit.containsKey(num * 2)){
                q.offer(num * 2);
                visit.put(num * 2, cnt + 1);
            }
            if (num * 3 <= y && !visit.containsKey(num * 3)){
                q.offer(num * 3);
                visit.put(num * 3, cnt + 1);
            }
        }
        return -1;
    }
}