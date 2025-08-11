package org.algorithm.투포인터.합이0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) break;
            int num = arr[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = num + arr[left] + arr[right];

                if (sum == 0) {
                    int l = 1;
                    int r = 1;
                    if (arr[left] == arr[right]) {
                        int a = right - left + 1;
                        cnt += comb(a);
                        break;
                    }
                    while (arr[left] == arr[left + 1]) {
                        l++;
                        left++;
                    }
                    while (arr[right] == arr[right - 1]) {
                        r++;
                        right--;
                    }

                    cnt += l * r;
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(cnt);
    }

    static int comb(int n) {
        return n * (n - 1) / 2;
    }
}
