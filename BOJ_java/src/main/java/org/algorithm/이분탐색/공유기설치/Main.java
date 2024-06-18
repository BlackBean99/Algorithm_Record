package org.algorithm.이분탐색.공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, c;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int lo = 1;
        int hi = houses[n - 1] - houses[0] + 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canInstall(mid) < c) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(lo - 1);
    }

    private static int canInstall(int distance) {
        int count = 1;
        int current = houses[0];
        for (int i = 1; i < n; i++) {
            if (houses[i] - current >= distance) {
                count++;
                current = houses[i];
            }
        }
        return count;
    }
}
