package org.algorithm.이분탐색.색종이와가위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        n = Long.parseLong(a[0]);
        k = Long.parseLong(a[1]);

        boolean answer = false;
        long left = 0; // 수정: 경계 조건을 0으로 설정
        long right = n; // 수정: 경계 조건을 n으로 설정

        while (left <= right) { // 수정: 종료 조건을 left <= right로 설정
            long mid = (left + right) / 2; // 수정: 반복문 내부에서 mid 값 계산

            long aVal = mid;
            long bVal = n - mid;
            if ((aVal + 1) * (bVal + 1) == k) {
                answer = true;
                break;
            }

            if ((aVal + 1) * (bVal + 1) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer ? "YES" : "NO");
    }
}
