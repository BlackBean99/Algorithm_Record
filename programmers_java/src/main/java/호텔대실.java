import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        // 예약 목록을 (입실, 퇴실) 리스트로 변환
        List<int[]> times = new ArrayList<>();
        for (String[] book : book_time) {
            int startTime = convertToMinutes(book[0]);
            int endTime = convertToMinutes(book[1]) + 10; // 청소시간 포함
            times.add(new int[]{startTime, endTime});
        }

        // 입실 시간 기준 정렬 (같으면 퇴실 시간 기준)
        Collections.sort(times, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 퇴실 시간을 저장하는 우선순위 큐 (가장 빠른 퇴실 시간이 먼저 나옴)
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int[] time : times) {
            int start = time[0], end = time[1];

            // 기존 방 중 사용할 수 있는 방 찾기
            if (!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll(); // 사용한 방 제거
            }

            // 새 방 추가
            rooms.offer(end);
        }

        return rooms.size(); // 최소한의 방 개수
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
