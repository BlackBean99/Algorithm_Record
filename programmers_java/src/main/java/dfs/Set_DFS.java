package dfs;

import java.util.*;
public class Set_DFS {
    private static int minIndexSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 예시 데이터
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>(Arrays.asList(2, 3)));
        map.put(2, new HashSet<>(Arrays.asList(5)));
        map.put(3, new HashSet<>(Arrays.asList(2, 4)));
        map.put(4, new HashSet<>(Arrays.asList(1, 2)));

        int targetSum = 7; // 목표 합

        // DFS 탐색 시작
        dfs(map, new ArrayList<>(map.keySet()), 0, targetSum, 0, 0);

        if (minIndexSum == Integer.MAX_VALUE) {
            System.out.println("조건을 만족하는 조합이 없습니다.");
        } else {
            System.out.println("키들의 합의 최솟값: " + minIndexSum);
        }
    }

    private static void dfs(Map<Integer, Set<Integer>> map, List<Integer> keys, int currentIndex, int targetSum, int currentSum, int currentIndexSum) {
        if (currentSum == targetSum) {
            minIndexSum = Math.min(minIndexSum, currentIndexSum);
            return;
        }

        if (currentIndex >= keys.size() || currentSum > targetSum) {
            return;
        }

        int key = keys.get(currentIndex);
        Set<Integer> values = map.get(key);

        // 현재 키의 각 값을 선택하여 재귀 호출
        for (int value : values) {
            dfs(map, keys, currentIndex + 1, targetSum, currentSum + value, currentIndexSum + key);
        }

        // 현재 키를 선택하지 않고 다음으로 진행
        dfs(map, keys, currentIndex + 1, targetSum, currentSum, currentIndexSum);
    }
}