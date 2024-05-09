package org.algorithm.구현.센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<List<Integer>> bound = new LinkedList<>(); // 각 바운드에 해당하는 정수 리스트의 리스트
        for (int i = 0; i <= k + 1; i++) {
            bound.add(new LinkedList<>()); // 각 바운드에 빈 리스트를 추가
        }
        int[] arr = new int[n]; // 입력으로 받은 정수 배열
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 스트림으로부터 문자열 토큰 분석
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 다음 정수를 문자열에서 파싱하여 배열에 저장
        }
        Arrays.sort(arr);
        int[] diff = new int[n];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(diff);
        int answer = 0;
        for (int i = 0; i <= n - k; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
