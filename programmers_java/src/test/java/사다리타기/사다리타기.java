package 사다리타기;

import java.util.*;

class Solution {
    static int[] arr;

    public char[] solution(int n, int[][] ladder) {
        arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        char[] answer = new char[n];
        for (int[] temp : ladder) {
            for (int i = 0; i < temp.length; i++) {
                swap(temp[i], temp[i] + 1);
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            answer[i] = (char) ((char) arr[i] + 63);
        }
        return answer;
    }

    public void swap(int a, int b) {
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][] {{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(
                Arrays.toString(T.solution(7, new int[][] {{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(
                Arrays.toString(
                        T.solution(8, new int[][] {{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(
                Arrays.toString(
                        T.solution(
                                12,
                                new int[][] {
                                    {1, 5, 8, 10},
                                    {2, 4, 7},
                                    {1, 5, 7, 9, 11},
                                    {2, 5, 7, 10},
                                    {3, 6, 8, 11}
                                })));
    }
}
