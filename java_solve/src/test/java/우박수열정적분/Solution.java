package 우박수열정적분;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int k1 = 5;
        int[][] ranges1 = new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        double[] answer1 = new double[]{33.0, 31.5, 0.0, -1.0};
        double[] result1 = new Solution().solution(k1, ranges1);
        PRINT_RESULT(1, result1, answer1);

        int k2 = 3;
        int[][] ranges2 = new int[][]{{0, 0}, {1, -2}, {3, -3}};
        double[] answer2 = new double[]{47.0, 36.0, 12.0};
        double[] result2 = new Solution().solution(k2, ranges2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, double[] result, double[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public double[] solution(int k, int[][] ranges) {
        // 1) get origin range
        List<Integer> map = getMap(k);
        int n = map.size() - 1;
        double[] answer = new double[ranges.length];
        double[] sizeMap = new double[n];
        int[][] originRange = convertRange(ranges, n);


        for (int i = 0; i < n; i++) {
            sizeMap[i] = (float)(map.get(i) + map.get(i + 1)) / 2;
        }

        for (int i = 0; i < originRange.length; i++) {
            float size = 0;
            if(originRange[i][0] > originRange[i][1]){
                answer[i] = -1;
                continue;
            }
            for (int j = originRange[i][0]; j < originRange[i][1]; j++) {

                size += sizeMap[j];
            }
            answer[i] = size;
        }
        return answer;
    }

    private List<Integer> getMap(int k) {
        int cur = k;
        List<Integer> map = new LinkedList<>();
        map.add(k);
        while (cur > 1) {
            if (cur % 2 == 0) {
                cur /= 2;
            } else {
                cur = cur * 3 + 1;
            }
            map.add(cur);
        }
        return map;
    }

    private int[][] convertRange(int[][] ranges, int n) {
        int[][] convertedRange = new int[ranges.length][ranges[0].length];
        for (int i = 0; i < ranges.length; i++) {
            convertedRange[i][0] = ranges[i][0];
            convertedRange[i][1] = n + ranges[i][1];
        }
        return convertedRange;
    }
}