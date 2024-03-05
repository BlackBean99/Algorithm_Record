package 네트워크;

class Solution {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer1 = 2;
        int result1 = new Solution().solution(n1, computers1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 3;
        int[][] computers2 = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int answer2 = 1;
        int result2 = new Solution().solution(n2, computers2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n]; // 각 컴퓨터의 방문 여부를 나타내는 배열

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) { // 아직 방문하지 않은 컴퓨터인 경우
                answer++; // 새로운 네트워크 시작
                dfs(i, visited, computers);
            }
        }

        return answer;
    }

    private void dfs(int index, int[] visited, int[][] computers) {
        visited[index] = -1; // 방문한 것으로 표시
        for (int i = 0; i < visited.length; i++) {
            if (i != index && visited[i] == 0 && computers[index][i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }
}
