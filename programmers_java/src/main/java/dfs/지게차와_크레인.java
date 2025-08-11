package dfs;

import java.util.*;

public class 지게차와_크레인 {


    private static int n, m;
    private static char[][] storage;
    private static boolean[][] visited;
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    // 4면중 1면이라도 연결된 컨테이너는 꺼낼 수 있는 컨테이너다.
    

    public static int solution(String[] storageInput, String[] requests) {
        n = storageInput.length;
        m = storageInput[0].length();
        storage = new char[n][m];

        // storage 초기화
        for (int i = 0; i < n; i++) {
            storage[i] = storageInput[i].toCharArray();
        }

        // 요청 처리
        for (String request : requests) {
            char target = request.charAt(0);
            if (request.length() == 2) {
                // 크레인 사용: 해당 종류의 모든 컨테이너 제거
                removeAll(target);
            } else {
                // 지게차 사용: 외부와 연결된 해당 종류의 컨테이너 제거
                removeAccessible(target);
            }
        }

        // 남은 컨테이너 수 계산
        return countRemainingContainers();
    }

    private static void removeAll(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == target) {
                    storage[i][j] = '.';
                }
            }
        }
    }

    private static void removeAccessible(char target) {
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 가장자리에서 시작
        for (int i = 0; i < n; i++) {
            if (storage[i][0] == target) {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (storage[i][m - 1] == target) {
                queue.add(new int[]{i, m - 1});
                visited[i][m - 1] = true;
            }
        }
        for (int j = 0; j < m; j++) {
            if (storage[0][j] == target) {
                queue.add(new int[]{0, j});
                visited[0][j] = true;
            }
            if (storage[n - 1][j] == target) {
                queue.add(new int[]{n - 1, j});
                visited[n - 1][j] = true;
            }
        }

        // BFS를 사용하여 외부와 연결된 컨테이너 제거
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            storage[x][y] = '.';

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && storage[nx][ny] == target) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    private static int countRemainingContainers() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
        System.out.println(solution(storage, requests)); // 출력: 11

        String[] storage2 = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests2 = {"C", "B", "B", "B", "B", "H"};
        System.out.println(solution(storage2, requests2)); // 출력: 4
    }
}
