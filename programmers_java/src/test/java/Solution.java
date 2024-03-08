import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int fuel = 19;
        int[][] fees = new int[][] {{4, 1000}, {6, 1000}, {21, 3000}, {16, 2000}, {26, 3000}};
        int t = 27;
        long[] result = new long[] {3000, 4000};
        long[] solution = new Solution().solution(fees, t);
        //        PRINT_RESULT(1, result, solution);
    }

    public static void PRINT_RESULT(int index, long[] result, long[] answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public long[] solution(int[][] fees, int t) {
        long[] answer = new long[2];
        // 기준 시간 a 찾기
        int possibleStartA = 0;
        int possibleEndA = 0;
        int b = 0;
        Collections.sort(Arrays.asList(fees), (o1, o2) -> o1[1] - o2[1]);
        for (int i = 1; i < fees.length; i++) {
            if (fees[i][1] > fees[i - 1][1]) {
                b = fees[i - 1][1];
                possibleStartA = fees[i - 1][0] + 1;
                possibleEndA = fees[i][0] - 1;
                break;
            }
        }
        boolean sig = true;
        long minCost = Integer.MAX_VALUE;
        long maxCost = 0;
        for (int i = possibleStartA; i <= possibleEndA; i++) {
            for (int j = 0; j < fees.length; j++) {
                if (isRange(fees[j][0], fees[j][1], i, b)) {
                    // t일 경우의 minCost, maxCost
                    // a ~ 2*a-1 분일 경우
                    long cost = 0;
                    // t일때 cost
                    if (t % i == 0) {
                        cost = (long) b * ((t) / i) + b;
                        break;
                    } else {
                        cost = (long) b * ((t) / i);
                    }
                    System.out.println(cost);
                    minCost = Math.min(minCost, cost);
                    maxCost = Math.max(maxCost, cost);
                }
            }
        }

        answer = new long[] {minCost, maxCost};
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    public boolean isRange(int myTime, int myCost, int possibleStartA, int b) {
        // a ~ 2*a-1 분일 경우
        boolean sig = false;
        int index = 1;
        while (!sig) {
            if ((possibleStartA * index <= myTime) && (myTime < possibleStartA * (index + 1))) {
                sig = true;
                index++;
                return myCost == (index - 1) * b;
            }
            if (myTime < possibleStartA * index) {
                return false;
            }
            index++;
        }
        return false;
    }
}
