package org.algorithm.백트래킹.전력을둘로가르기;
import java.util.*;

class Solution {
    private int n; // 전역 변수로 n 저장

    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = Integer.MAX_VALUE; // 최소값을 찾아야 하므로 초기값을 큰 값으로 설정

        for (int i = 0; i < wires.length; i++) { // n이 아니라 wires.length까지 반복해야 함
            answer = Math.min(disconnectTarget(i, wires), answer);
        }
        return answer;
    }

    private int disconnectTarget(int target, int[][] wires) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // 그래프 구성 (target 번째 간선 제외)
        for (int i = 0; i < wires.length; i++) {
            if (i == target) continue;
            map.putIfAbsent(wires[i][0], new ArrayList<>());
            map.putIfAbsent(wires[i][1], new ArrayList<>());
            map.get(wires[i][0]).add(wires[i][1]);
            map.get(wires[i][1]).add(wires[i][0]);
        }

        boolean[] visited = new boolean[n + 1]; // 1-based index를 고려해 n+1 크기로 선언
        List<Integer> answers = new ArrayList<>();
        
        // BFS를 통해 연결된 송전탑 개수 구하기
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map.containsKey(i)) { // 방문하지 않았으며 노드가 존재하면 BFS 실행
                answers.add(bfs(map, i, visited));
            }
        }

        // 두 개의 그룹으로 나뉘었을 것이므로 차이 계산
        if (answers.size() < 2) return Integer.MAX_VALUE; // 잘못 나눠진 경우 예외 처리
        int a = answers.get(0);
        int b = answers.get(1);
        return Math.abs(a - b);
    }

    private int bfs(Map<Integer, List<Integer>> map, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int area = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int neighbor : map.getOrDefault(current, Collections.emptyList())) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                    area++;
                }
            }
        }
        return area;
    }
}
