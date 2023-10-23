package 주차요금계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public static void main(String[] args) {
        int[] fees1 = new int[]{180, 5000, 10, 600};
        String[] records1 = new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] answer1 = new int[]{14600, 34400, 5000};
        List<Integer> result1 = new Solution().solution(fees1, records1);
//        int[] result1 = new Solution().solution(fees1, records1);
        PRINT_RESULT(1, result1, answer1);

        int[] fees2 = new int[]{120, 0, 60, 591};
        String[] records2 = new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        int[] answer2 = new int[]{0, 591};
        int[] result2 = new Solution().solution(fees2, records2);
        PRINT_RESULT(2, result2, answer2);

        int[] fees3 = new int[]{1, 461, 1, 10};
        String[] records3 = new String[]{"00:00 1234 IN"};
        int[] answer3 = new int[]{14841};
        int[] result3 = new Solution().solution(fees3, records3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, List<Integer> result, List<Integer> answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
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

    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new LinkedList<>();
        //records
//        ["05:34 5961 IN",
//        "06:00 0000 IN",
//        "06:34 0000 OUT",
//        "07:59 5961 OUT",
//        "07:59 0148 IN",
//        "18:59 0000 IN",
//        "19:09 0148 OUT",
//        "22:59 5961 IN",
//        "23:00 5961 OUT"]
//        LinkedList<Record> record = new LinkedList<>();
        int zeroTime = 60*24;
        Map<Integer, Record> record = new HashMap<>();
        for (String r : records) {
            String[] s = r.split(" ");
            String[] stringTime = s[0].split(":");
            int time =Integer.parseInt(stringTime[0])*60 + Integer.parseInt(stringTime[1]);

            if(record.containsKey(Integer.parseInt(s[1]))){
                Record record1 = record.get(Integer.parseInt(s[1]));
                int start = record1.getStart();
                record.put(Integer.parseInt(s[1]), new Record(start, time, false));
            }else{
                record.put(Integer.parseInt(s[1]), new Record(time, true));
            }
        }


        Map<Integer, Record> sortedMap = new TreeMap<>(record);
        // 차량 번호가 작은 차량 부터 삽입할거임 -> 넣어놓고 나중에 정렬할거임
        int index = 0;
        for (Map.Entry<Integer, Record> entry : sortedMap.entrySet()) {

            Integer key = entry.getKey();
            Record value = entry.getValue();
            // 걸린 시간이 기본시간 이내라면?
            if(zeroTime - value.getStart() < fees[0] || (!value.isIn && value.getEnd() - value.getStart() < fees[0])) {
                answer.add(fees[1]);
                continue;
            }
            // 아직 안나갔으면
            if(value.isIn) {
                int during = zeroTime - value.getStart();
                // 기본요금 배수 + 올림 배수
                int partition = during / fees[2];
                if(during % 10 > 0) partition++;
                answer.add(fees[3] * partition);
            }else {
                // 출차 기록이 있으면?
                int during = value.end - value.start;
                int partition = during / fees[2];
                if(during % 10 > 0) partition++;
                answer.add(fees[3] * partition);
            }
        }
        return answer;
    }
//        [180, 5000, 10, 600]
//        기본시간, 기본요금, 단위 시간, 단위 요금
            //1, 현재 시간이 기본요금 안에 끝나는 시간인가 func
        // 5. 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다
        // 4.초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
        // 2. 기본요금을 초과하는 시간이라면 얼마나 초과했나
        // 3. 초과한 시간만큼 금액을 주면 얼마냐? func
}
class Record{
    public Record(int start, int end, boolean isIn) {
        this.start = start;
        this.end = end;
        this.isIn = isIn;
    }

    public int start;
    public int end;
    public boolean isIn;

    public Record(int start, boolean isIn) {
        this.start = start;
        this.end = 0;
        this.isIn = isIn;
    }

    public int getStart(){
        return this.start;
    }

    public int getEnd() {
        return this.end;
    }
}