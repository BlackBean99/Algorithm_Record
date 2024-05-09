package org.algorithm.우선순위큐.N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                q.add(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            q.poll();
        }
        System.out.println(q.poll());
    }
}
