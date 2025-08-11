package dfs;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>();
        List<Integer> priorityList = new ArrayList<>();
        
        // 큐 초기화
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i}); // {우선순위, 인덱스}
            priorityList.add(priorities[i]);
        }
        
        // 우선순위 정렬
        priorityList.sort(Collections.reverseOrder()); // 내림차순 정렬
        
        int count = 0; // 실행 순서
        
        while (!q.isEmpty()) {
            int[] process = q.poll();
            
            // 현재 프로세스의 우선순위가 가장 높은지 확인
            if (process[0] == priorityList.get(0)) {
                count++; // 실행됨
                priorityList.remove(0); // 실행된 우선순위 제거
                
                if (process[1] == location) { // 목표 프로세스 실행됨
                    return count;
                }
            } else {
                q.add(process); // 다시 큐에 삽입
            }
        }
        
        return -1; // 예외적으로 실행되지 않는 경우 (없음)
    }
}
