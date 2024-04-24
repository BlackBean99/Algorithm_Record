package org.algorithm.이차원배열과연산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int xLength = 3;
    static int yLength = 3;
    static int r, c, k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        arr = new int[101][101];
        // r,c가 k가 될때까지 반복
        // arr 는 3

        StringTokenizer st;
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = process();
        System.out.println(answer);
    }

    private static int process() {
        for (int time = 0; time <= 100; time++) {
            if (arr[r][c] == k) {
                return time;
            }
            operating();
        }
        return -1;
    }

    // R 연산 : 배열 A의 모든 행에 대해서 정렬을 수행한다
    // C 연산 : 배열 A의 모든 열에 대해서 정렬을 수행한다
    static void operating() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                rProcess(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                cProcess(i);
            }
        }
    }

    public static void rProcess(int key) {
        // Comparator를 정의하여 TreeMap에 값으로 정렬하고 값이 같으면 키로 정렬하도록 합니다.
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= yLength; i++) {
            if (arr[key][i] == 0) continue;
            map.compute(arr[key][i], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[key][i++] = p.number;
            arr[key][i++] = p.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            arr[key][i++] = 0;
            arr[key][i++] = 0;
        }
    }

    public static void cProcess(int key) {
        // Comparator를 정의하여 TreeMap에 값으로 정렬하고 값이 같으면 키로 정렬하도록 합니다.
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 1; i <= yLength; i++) {
            if (arr[key][i] == 0) continue;
            map.compute(arr[key][i], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[i++][key] = p.number;
            arr[i++][key] = p.count;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            arr[i++][key] = 0;
            arr[i++][key] = 0;
        }
    }

    static class Pair implements Comparable<Pair> {

        int number;
        int count;

        Pair(int n, int c) {
            this.number = n;
            this.count = c;
        }

        // count 가 작은 게 앞으로, 같으면 number 가 작은게 앞으로
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.number - o.number;
            } else {
                return -1;
            }
        }
    }
}
