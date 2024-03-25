package org.algorithm.블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] visits = new int[n];
        for (int i = 0; i < n; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }
        //        초기 합을 구하자
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += visits[i];
        }
        int answer = sum;
        int answerCnt = 0;

        for (int i = x; i < n; i++) {
            sum += visits[i] - visits[i - x];
            if (answer == sum) answerCnt++;
            else if (answer < sum) {
                answer = sum;
                answerCnt = 1;
            }
        }

        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.println(answerCnt);
        }
    }
}
