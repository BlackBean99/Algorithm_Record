package org.algorithm.이분탐색.구간나누기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
            min = Math.max(arr[i], min);
        }

        int left = 0;
        // 최댓값이 right로 초기화
        int right = max - min;
        while (left <= right) {
            int mid = (left + right) /2;
            if (canDivideByMid(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean canDivideByMid(int mid) {
        int count = 1;
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (max - min > mid) {
                min = arr[i];
                max = arr[i];
                // 새로운 구간을 찾으려는 초기화 행위이다.
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

}