package org.algorithm.겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        int[] cnt = new int[100001];

        while (end < arr.length) {
            while (end < arr.length && cnt[arr[end]] + 1 <= k) {
                cnt[arr[end]]++;
                end++;
            }
            int len = end - start;
            answer = Math.max(answer, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(answer);
    }
}
