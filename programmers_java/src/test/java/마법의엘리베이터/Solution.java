package 마법의엘리베이터;

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
class Solution {
    public static void main(String[] args) {
        int storey1 = 16;
        int answer1 = 6;
        int result1 = new Solution().solution(storey1);
        PRINT_RESULT(1, result1, answer1);

        int storey2 = 2554;
        int answer2 = 16;
        int result2 = new Solution().solution(storey2);
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

    public int solution(int storey) {
        String tmp = Integer.toString(storey);
        int[] arr = new int[tmp.length()];
        for (int i = 0; i < tmp.length(); i++) {
            arr[i] = tmp.charAt(i) - '0';
        }
        int answer = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 5) {
                answer += 10 - arr[i];
                if (i == 0) answer++;
                else arr[i - 1]++;
            } else if (arr[i] == 5 && i > 0 && arr[i - 1] >= 5) {
                arr[i - 1]++;
                answer += 5;
            } else {
                answer += arr[i];
            }
        }
        return answer;
    }
}
