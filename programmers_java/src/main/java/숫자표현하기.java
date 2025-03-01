import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{x, 0});
        visited.add(x);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            int[] nextValues = {value * 2, value * 3, value + n};

            for (int next : nextValues) {
                if (next == y) {
                    return steps + 1;
                }
                if (next < y && !visited.contains(next)) {
                    queue.offer(new int[]{next, steps + 1});
                    visited.add(next);
                }
            }
        }

        return -1; // y에 도달할 수 없는 경우
    }
}
