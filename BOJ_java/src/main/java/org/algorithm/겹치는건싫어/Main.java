package org.algorithm.겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0;
        HashMap<Integer, Integer> cnts = new HashMap<>();
        while (end != n) {
            if (cnts.getOrDefault(arr[Math.max(end - 1, 0)], 0) > k) {
                cnts.put(
                        arr[start],
                        cnts.getOrDefault(arr[start], 0) == 0 ? 0 : cnts.get(arr[start]) - 1);
                start++;
                answer = Math.max(answer, end - start);
            } else {
                cnts.put(
                        arr[end], cnts.getOrDefault(arr[end], 0) == 0 ? 1 : cnts.get(arr[end]) + 1);
                end++;
                answer = Math.max(answer, end - start);
            }
        }
        System.out.println(Math.max(answer - 1, 0));
    }
}
