package org.algorithm.이분탐색.if문좀대신짜줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 징검다리건너기 {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[][] title = new String[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            title[i][0] = input[0];
            title[i][1] = input[1];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;
            int mid = (left + right) / 2;
            while (left <= right) {
                mid = (left + right) / 2;
                int titleInt = Integer.parseInt(title[mid][1]);
                if (titleInt < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(title[left][0] + "\n");
        }
        System.out.println(sb);
    }
}
