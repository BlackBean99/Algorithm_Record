import java.util.*;

class Solution {
    Map<String, List<Integer>> db = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        // 1. info 전처리
        for (String applicant : info) {
            String[] parts = applicant.split(" ");
            int score = Integer.parseInt(parts[4]);
            // 16가지 조합 생성
            makeCases(parts, score, 0, "");
        }

        // 각 리스트 정렬 (이진 탐색 대비)
        for (List<Integer> list : db.values()) {
            Collections.sort(list);
        }

        // 2. query 처리
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] parts = query[i].replaceAll(" and", "").split(" ");
            String key = String.join("", Arrays.copyOfRange(parts, 0, 4));
            int score = Integer.parseInt(parts[4]);

            if (!db.containsKey(key)) {
                answer[i] = 0;
                continue;
            }

            List<Integer> list = db.get(key);
            // lower bound (score 이상인 첫 위치 찾기)
            int idx = Collections.binarySearch(list, score);
            if (idx < 0) idx = -idx - 1;
            else {
                // 같은 점수 여러 개 있을 때 처리
                while (idx > 0 && list.get(idx - 1) >= score) idx--;
            }

            answer[i] = list.size() - idx;
        }

        return answer;
    }

    // 모든 경우의 수 만들기 (백트래킹)
    private void makeCases(String[] parts, int score, int depth, String key) {
        if (depth == 4) {
            db.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        // 해당 값 포함
        makeCases(parts, score, depth + 1, key + parts[depth]);
        // "-" 포함
        makeCases(parts, score, depth + 1, key + "-");
    }
}
