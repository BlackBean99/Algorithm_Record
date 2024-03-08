package 뒤에있는큰수찾기;

import java.util.Arrays;
import java.util.Stack;

/**
 * main, PRINT_RESULT 는 테스트 케이스 실행 및 결과 확인을 위한 함수입니다. [답안지 복사] 기능을 사용하는 경우 해당 함수들을 제외하며, 답안에 필요한 코드만
 * 복사됩니다. 테스트 케이스 추가 등 함수 내부 변경은 가능하나, 함수 이름 변경시 [답안지 복사] 기능이 제대로 동작하지 않습니다.
 *
 * <p>또한, 기본 설정으로 [답안지 복사] 사용시 해당 주석과 작성하신 주석을 제외하여 복사됩니다. [주석 복사] 여부는 설정을 통해 변경할 수 있습니다.
 *
 * <p>[도움말 주석] 옵션은 설정을 통해 제거할 수 있습니다.
 *
 * <p>- [답안지 복사] 코드 - 답안지 복사 (기본 단축키 cmd + shift + w)
 *
 * <p>- [도움말 주석] 설정 - 도구 - 프로그래머스 헬퍼 - 도움말 주석
 *
 * <p>- [주석 복사] 설정 - 도구 - 프로그래머스 헬퍼 - 주석 복사
 *
 * <p>GitHub: https://github.com/azqazq195/programmers_helper
 */
class Solution_Reverse {
    public static void main(String[] args) {
        int[] numbers1 = new int[] {2, 3, 3, 5};
        int[] answer1 = new int[] {3, 5, 5, -1};
        int[] result1 = new Solution_Reverse().solution(numbers1);
        PRINT_RESULT(1, result1, answer1);

        int[] numbers2 = new int[] {9, 1, 5, 3, 6, 2};
        int[] answer2 = new int[] {-1, 5, 6, 6, -1, -1};
        int[] result2 = new Solution_Reverse().solution(numbers2);
        PRINT_RESULT(2, result2, answer2);
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

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        // 첫번째 인덱스 push
        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}
