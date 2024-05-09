package org.algorithm.우선순위큐.중간값구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int midCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            // size는 무조건 홀수다.
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];

            if (size > 10) {
                int iteration = (size / 10) + 1;
                int index = 0;
                for (int j = 0; j < iteration; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    while (st.hasMoreTokens() || index % 10 == 9) {
                        arr[index++] = Integer.parseInt(st.nextToken());
                    }
                }
            } else {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int index = 0;
                while (st.hasMoreTokens()) {
                    arr[index++] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Integer> q = new PriorityQueue<>();
            PriorityQueue<Integer> temp = new PriorityQueue<>();

            midCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                q.add(arr[j]);
                // 홀수일 경우
                if (j % 2 == 0) {
                    temp.addAll(q);
                    midCount++;
                    getIndex(temp, (j + 1) / 2 + 1, sb);
                }
            }
            sb.insert(0, midCount + "\n");
            System.out.println(sb.toString());
        }
    }

    // n번째 큰 수
    private static void getIndex(PriorityQueue<Integer> q, int n, StringBuilder sb) {
        int index = 0;
        while (!q.isEmpty()) {
            index++;
            if (index == n) {
                if (index % 10 == 0) {
                    sb.append("\n");
                }
                sb.append(q.poll() + " ");
            } else {
                q.poll();
            }
        }
    }
}
