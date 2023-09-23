package 호텔대실;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        String[][] book_time1 = new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int answer1 = 3;
        int result1 = new Solution().solution(book_time1);
        PRINT_RESULT(1, result1, answer1);

        String[][] book_time2 = new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}};
        int answer2 = 1;
        int result2 = new Solution().solution(book_time2);
        PRINT_RESULT(2, result2, answer2);

        String[][] book_time3 = new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        int answer3 = 3;
        int result3 = new Solution().solution(book_time3);
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
    /**
    *  제한사항
        1 ≤ book_time의 길이 ≤ 1,000
        book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
        [대실 시작 시각, 대실 종료 시각] 형태입니다.
        시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
        예약 시각이 자정을 넘어가는 경우는 없습니다.
        시작 시각은 항상 종료 시각보다 빠릅니다.
    * */

    static class Book{
        private Integer start;
        private Integer end;

        public Book(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        // 반납시간
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                ((o1, o2) -> (
                   o1 - o2)
        ));
        // 대여시간을 기준으로 저장
        ArrayList<int[]> list = new ArrayList<>();
        for (String[] book : book_time) {
            int[] e = new int[2];
            e[0] = convert(book[0]);
            e[1] = convert(book[1]);
            list.add(e);
        }
        Collections.sort(list,(int[] o1, int[] o2) -> o1[0] - o2[0]);
        for (int[] e : list) {
            int start = e[0];
            int end = e[1];
            Integer prev = pq.peek();
            if (prev == null || prev > start) {
                pq.add(end + 10);
                answer += 1;
            } else if (prev != null && prev <= start) {
                pq.poll();
                pq.add(end + 10);
            }
        }
        return answer;
    }

    private Integer convert(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}