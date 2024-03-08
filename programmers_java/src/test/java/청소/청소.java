package 청소;

import java.util.*;

class Solution {
    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr1 = {
            {0, 0, 0, 0, 0}, {0, 1, 1, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {
            {0, 0, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
