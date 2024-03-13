package org.algorithm.맥주마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int start[] = new int[2];
        int end[] = new int[2];
        int[][] convinent;
        /**
         * 첫번째, 편의점 갯수
         * 2번째, start 좌표
         * 3번째부터 3+n개, n개의 편의점 좌표
         * 마지막, end 좌표
         * */
        for (int i = 0; i < testCase; i++) {

            int convenientNumber = Integer.parseInt(br.readLine());
            convinent = new int[convenientNumber+1][convenientNumber+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < convenientNumber; j++) {
                st = new StringTokenizer(br.readLine());
                convinent[j][0] = Integer.parseInt(st.nextToken());
                convinent[j][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            bfs(convinent, start, end);
        }
    }

    private static void bfs(int[][] convinent, int[] start, int[] end) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[convinent.length];
        q.add(new Node(start[0], start[1]));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (Math.abs(now.i - end[0]) + Math.abs(now.j - end[1]) <= 1000) {
                System.out.println("happy");
                return;
            }
            for (int i = 0; i < convinent.length; i++) {
                Node next = new Node(convinent[i][0], convinent[i][1]);
                if (Math.abs(now.i - next.i) + Math.abs(now.j - next.j) <= 1000) {
                    visited[i] = true;
                    q.add(new Node(next.i, next.j));
                }
            }
        }
        System.out.println("sad");
    }

}
class Node {
    int i, j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
