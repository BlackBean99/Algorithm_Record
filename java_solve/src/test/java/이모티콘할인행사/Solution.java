package 이모티콘할인행사;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {

        int[][] users2 =
                new int[][] {
                    {40, 2900},
                    {23, 10000},
                    {11, 5200},
                    {5, 5900},
                    {40, 3100},
                    {27, 9200},
                    {32, 6900}
                };
        int[] emoticons2 = new int[] {1300, 1500, 1600, 4900};
        int[] answer2 = new int[] {4, 13860};
        int[] result2 = new Solution().solution(users2, emoticons2);
        PRINT_RESULT(2, result2, answer2);

        int[][] users1 = new int[][] {{40, 10000}, {25, 10000}};
        int[] emoticons1 = new int[] {7000, 9000};
        int[] answer1 = new int[] {1, 5400};
        int[] result1 = new Solution().solution(users1, emoticons1);
        PRINT_RESULT(1, result1, answer1);
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

    public static List<int[]> discountList = new LinkedList<>();
    public static int totalRevenue = 0;
    public static int plusCnt = 0;

    static void comb(int[] arr, int[] output, int start, int depth, int n, int r) {
        if (depth == r) {
            discountList.add(Arrays.copyOf(output, output.length));
            return;
        }
        for (int i = start; i < n; i++) {
            // 재귀함수 호출
            output[depth] = arr[i];
            comb(arr, output, i, depth + 1, n, r); // i + 1이 아닌 i 대입, r - 1이 아닌 r 대입
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] arr = {10, 20, 30, 40}; // 중복 조합을 만들 배열
        int n = arr.length;
        comb(arr, new int[emoticons.length], 0, 0, n, emoticons.length); // n개중 r개를 중복 조합으로 뽑는 경우 출력

        List<Result> results = new LinkedList<>();
        for (int[] discounts : discountList) {
            int cnt = 0;
            int revenue = 0;

            for (int[] user : users) {
                int userMinDiscount = user[0];
                int userMaxPay = user[1];
                int sum = 0;

                for (int i = 0; i < discounts.length; i++) {
                    if (discounts[i] < userMinDiscount) continue;
                    sum += (emoticons[i] / 100) * (100 - discounts[i]);
                }
                if (userMaxPay <= sum) cnt++;
                else revenue += sum;
            }
            results.add(new Result(cnt, revenue));
        }
        results.sort(
                (o1, o2) -> {
                    if (o1.getPlusCnt() == o2.getPlusCnt())
                        return o2.getRevenue() - o1.getRevenue();
                    return o2.getPlusCnt() - o1.getPlusCnt();
                });

        return new int[] {results.get(0).plusCnt, results.get(0).getRevenue()};
    }

    public class Result {
        private int plusCnt;
        private int revenue;

        public Result(int plusCnt, int revenue) {
            this.plusCnt = plusCnt;
            this.revenue = revenue;
        }

        public int getPlusCnt() {
            return this.plusCnt;
        }

        public int getRevenue() {
            return this.revenue;
        }
    }
}
