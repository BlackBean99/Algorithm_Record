import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2]; // 사용 가능한 곡괭이 개수
        int maxMine = Math.min(minerals.length, totalPicks * 5); // 캘 수 있는 최대 광물 수
        int mineralGroups = (maxMine + 4) / 5; // 사용할 그룹 개수 (5개씩 묶음)

        // 1. 캘 수 있는 광물까지만 그룹화
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < mineralGroups; i++) {
            int[] count = new int[3]; // [다이아 개수, 철 개수, 돌 개수]
            for (int j = 0; j < 5 && i * 5 + j < maxMine; j++) {
                if (minerals[i * 5 + j].equals("diamond")) count[0]++;
                else if (minerals[i * 5 + j].equals("iron")) count[1]++;
                else count[2]++;
            }
            groups.add(count);
        }
        
        // 2. 사용할 그룹만 중요도 순으로 정렬 (뒤에 있는 광물은 정렬 대상 아님)
        groups.sort((a, b) -> (b[0] - a[0] != 0) ? (b[0] - a[0]) : (b[1] - a[1]));

        // 3. 곡괭이 사용 (다이아 → 철 → 돌 순서)
        for (int[] group : groups) {
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
