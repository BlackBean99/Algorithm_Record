import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2]; // 총 곡괭이 개수
        int maxMine = Math.min(minerals.length, totalPicks * 5); // 캘 수 있는 최대 광물 수

        // 1. PriorityQueue를 사용해 중요도 높은 그룹을 우선 처리
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0]; // 다이아 개수 우선 정렬
            return b[1] - a[1]; // 다이아 개수가 같다면 철 개수 정렬
        });

        // 2. 캘 수 있는 광물까지만 그룹화 (5개씩)
        for (int i = 0; i < maxMine; i += 5) {
            int[] count = new int[3]; // [다이아 개수, 철 개수, 돌 개수]
            for (int j = i; j < i + 5 && j < maxMine; j++) {
                if (minerals[j].equals("diamond")) count[0]++;
                else if (minerals[j].equals("iron")) count[1]++;
                else count[2]++;
            }
            pq.offer(count); // 우선순위 큐에 삽입
        }

        // 3. 곡괭이를 사용해 최소 피로도 계산
        while (!pq.isEmpty()) {
            int[] group = pq.poll(); // 가장 중요한 그룹 꺼내기
            if (picks[0] > 0) { // 다이아 곡괭이 사용
                answer += group[0] + group[1] + group[2];
                picks[0]--;
            } else if (picks[1] > 0) { // 철 곡괭이 사용
                answer += group[0] * 5 + group[1] + group[2];
                picks[1]--;
            } else if (picks[2] > 0) { // 돌 곡괭이 사용
                answer += group[0] * 25 + group[1] * 5 + group[2];
                picks[2]--;
            }
        }

        return answer;
    }
}
