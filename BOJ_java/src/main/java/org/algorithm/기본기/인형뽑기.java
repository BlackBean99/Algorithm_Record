import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int col = move - 1; // 1-based → 0-based
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {
                    int doll = board[row][col];
                    board[row][col] = 0; // 인형 꺼내기

                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2; // 두 개 터짐
                    } else {
                        stack.push(doll);
                    }
                    break; // 해당 열에서 인형을 뽑았으므로 다음 move 진행
                }
            }
        }
        return answer;
    }
}
