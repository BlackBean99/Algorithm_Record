package 과제진행하기;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import org.junit.platform.commons.util.StringUtils;

class Solution {
    public static void main(String[] args) {
        String[][] plans1 = new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[] answer1 = new String[]{"korean", "english", "math"};
        String[] result1 = new Solution().solution(plans1);
        PRINT_RESULT(1, result1, answer1);

        String[][] plans2 = new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[] answer2 = new String[]{"science", "history", "computer", "music"};
        String[] result2 = new Solution().solution(plans2);
        PRINT_RESULT(2, result2, answer2);

        String[][] plans3 = new String[][]{{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[] answer3 = new String[]{"bbb", "ccc", "aaa"};
        String[] result3 = new Solution().solution(plans3);
        PRINT_RESULT(3, result3, answer3);
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

    static public class TimeTable {
        private String name;
        private Integer start;
        private Integer playTime;

        public TimeTable(String name, Integer start, Integer playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        public TimeTable(String name, Integer playTime) {
            this.name = name;
            this.playTime = playTime;
        }
    }

    public String[] solution(String[][] plans) {
        // 정답을 저장할 리스트
        List<String> answer = new ArrayList<>();
        PriorityQueue<TimeTable> pq = new PriorityQueue<>(
                ((o1, o2) -> (o1.start - o2.start))
        );
        // TimeTable 클래스 정의
        for (String[] plan : plans) {
            int start = convertToMinute(plan[1]);
            int playtime = start + Integer.parseInt(plan[2]);
            pq.add(new TimeTable(plan[0], start, playtime));
        }
        // 잠시 멈춘 과제를 저장
        Stack<TimeTable> remainingTasks = new Stack<>();
        while (!pq.isEmpty()) {
            TimeTable currentTimeTable = pq.poll();

            String curName = currentTimeTable.name;
            int curStart = currentTimeTable.start;
            int curPlaytime = currentTimeTable.playTime;

            int currentTime = curStart;
            // 새로운 과제가 남아있는 경우(진행중이던 과제 제외)
            if (!pq.isEmpty()) {
                TimeTable nextTimeTable = pq.peek();
                // 지금 과제 끝나고도 시간이 남는경우
                if (currentTime + curPlaytime < nextTimeTable.playTime) {
                    answer.add(curName);
                    currentTime += curPlaytime;
                    // 잠시 멈춘과제가 있는 경우 꺼내서 과제를 진행한다.
                    while (!remainingTasks.isEmpty()) {
                        TimeTable rem = remainingTasks.pop();

                        if (currentTime + rem.playTime < nextTimeTable.start) {
                            currentTime += rem.playTime;
                            answer.add(rem.name);
                            continue;
                        }
                        // 다음 새로운 과제 전에 다 못끝내는 경우
                        else {
                            int t = rem.playTime - (nextTimeTable.start - currentTime);
                            // 추가로 한 시간만 빼서 멈춘 과제 목록에 다시 추가
                            remainingTasks.push(new TimeTable(rem.name, t));
                            break;
                        }
                    }
                }
                // 지금 과제를 끝내는 시간에 딱 다른 과제가 있는 경우
                else if (currentTime + curPlaytime == nextTimeTable.playTime) {
                    answer.add(curName);
                } else {
                    int t = nextTimeTable.start - currentTime;
                    remainingTasks.add(new TimeTable(curName, curPlaytime, t));
                }
            }
            // 더는 더 남아있는 새로운 과제가 없는 경우
            else {
                // 남아있는 과제
                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if (remainingTasks.isEmpty()) {
                    currentTime += curPlaytime;
                    answer.add(curName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    answer.add(curName); // 새로운 과제부터 먼저 해결

                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while (!remainingTasks.isEmpty()) {
                        TimeTable rem = remainingTasks.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }
        return answer.toArray(new String[0]);
    }

//        --------------------------------------------------------------------------------------------------ㅍ
//
//        List<TimeTable> timeTables = new ArrayList<>();
//        Stack<TimeTable> stack = new Stack<>();
//
//        // 과제 일정을 TimeTable 객체로 변환하여 리스트에 추가

//
//        // 시작 시간(start)을 기준으로 내림차순 정렬
//        timeTables.sort((o1, o2) -> o2.start - o1.start);
//
//        answerList.add(timeTables.get(0).name); // 초기에 시작하는 과목 추가
//        for (int i = 0; i < timeTables.size(); i++) {
//            TimeTable current = timeTables.get(i);
//
//            // 스택에 과제가 있고, 현재 과제의 시작 시간이 스택의 가장 위 과제의 종료 시간보다 빠른 경우
//            while (!stack.isEmpty() && current.start < stack.peek().end) {
//                // 스택의 가장 위에 있는 과제를 중단하고 스택에서 제거
//                TimeTable stopped = stack.pop();
//                // 중단된 과제를 이어서 진행하고, 이어서 진행한 시간을 answerList에 기록
//                answerList.add(stopped.name);
//                // 현재 과제의 시작 시간을 중단된 과제의 종료 시간으로 업데이트
//                current.start = stopped.end;
//            }
//
//            // 현재 과제를 완료하고 answerList에 기록 (중단된 경우는 기록하지 않음)
//            if (current.start < current.end) {
//                answerList.add(current.name);
//                // 현재 과제를 중단하거나 스택에 추가
//                stack.push(current);
//            }
//        }
//        // ArrayList를 String 배열로 변환하여 반환
//        return answerList.toArray(new String[0]);

    // 분 단위 시간을 "hh:mm" 형식의 문자열로 변환하는 메서드
    private String convertToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }


    private Integer convertToMinute(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]) * 60;
        int minute = Integer.parseInt(split[1]);
        return hour + minute;
    }
}