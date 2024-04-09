package org.algorithm.행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] map;
    static int k, n;
    static int answer;

    public static void main(String[] args) throws IOException {
        answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        map = new int[n];
        int[] diff = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        for (int i = 0; i < n - 1; i++) {
            diff[i] = map[i + 1] - map[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < n - k; i++) {
            answer += diff[i];
        }

        System.out.println(answer);
    }
}
