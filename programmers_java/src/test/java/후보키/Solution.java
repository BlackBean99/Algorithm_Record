package 후보키;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[][] relation =
                new String[][] {
                    {"100", "ryan", "music", "2"},
                    {"200", "apeach", "math", "2"},
                    {"300", "tube", "computer", "3"},
                    {"400", "con", "computer", "4"},
                    {"500", "muzi", "music", "3"},
                    {"600", "apeach", "music", "2"}
                };
        int result = 2;
        PRINT_RESULT(1, new Solution().solution(relation), result);
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

    List<String> candi = new ArrayList<>();

    public int solution(String[][] relation) {
        int answer = 0;
        for (int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited, 0, 0, i + 1, relation);
        }
        answer = candi.size();
        return answer;
    }

    public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new LinkedList<>();
            String key = "";
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < relation.length; i++) {
                String s = "";
                // 임시 후보키를 문장으로 만들어서 하나의 문자열로 만든다.
                for (Integer j : list) {
                    s += relation[i][j];
                }
                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }
            for (String s : candi) {
                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    String subS = String.valueOf(key.charAt(i));
                    if (s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            candi.add(key);
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }
    }
}
