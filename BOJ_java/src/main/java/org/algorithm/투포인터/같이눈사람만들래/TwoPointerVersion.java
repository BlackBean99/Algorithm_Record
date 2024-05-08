package org.algorithm.투포인터.같이눈사람만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoPointerVersion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int x1 = arr[i] + arr[j];
                int start = 0;
                int end = n - 1;
                while (start < end) {
                    if (start == i || start == j) {
                        start++;
                        continue;
                    }
                    if (end == i || end == j) {
                        end--;
                        continue;
                    }

                    int x2 = arr[end] - arr[start];
                    min = Math.min(min, Math.abs(x2 - x1));
                    if (x1 > x2) {
                        start++;
                    } else if (x1 < x2) {
                        end--;
                    } else{
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
    }

}
