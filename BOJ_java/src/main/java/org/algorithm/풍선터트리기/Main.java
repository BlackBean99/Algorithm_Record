package org.algorithm.풍선터트리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ballonLocation = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ballonLocation[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        StringBuilder sb = new StringBuilder();
        Deque<Balloon> queue = new ArrayDeque<>();
        sb.append("1 ");
        int moveValue = ballonLocation[0];
        for (int i = 1; i < n; i++) {
            queue.add(new Balloon(i + 1, ballonLocation[i]));
        }
        while (!queue.isEmpty()) {
            if (moveValue > 0) {
                // 앞의 요소를 뒤로 보낸다.
                for (int i = 1; i < moveValue; i++) {
//                    <<
                    queue.add(queue.poll());
//                    queue.addLast(queue.pollFirst());
                }
                Balloon next = queue.poll();
                moveValue = next.numValue;
                sb.append(next.index + " ");
            }
            else {
                for (int i = 1; i < -moveValue; i++) {
//                    >>
                    queue.addFirst(queue.pollLast());
                }
                Balloon next = queue.pollLast();
                moveValue = next.numValue;
                sb.append(next.index + " ");
            }
        }
        System.out.println(sb);
    }
    static class Balloon {
        int index;
        int numValue;


        public Balloon(int index, int numValue) {
            this.index = index;
            this.numValue = numValue;
        }
    }
}