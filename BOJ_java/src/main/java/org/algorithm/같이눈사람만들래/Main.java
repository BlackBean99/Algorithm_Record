package org.algorithm.같이눈사람만들래;

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
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Case> sumCase = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                sumCase.add(new Case(i, j, arr[i] + arr[j]));
            }
        }
        sumCase.sort((Case o1, Case o2) -> o1.sum - o2.sum);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sumCase.size() - 1; i++) {
            Case x1 = sumCase.get(i);
            Case x2 = sumCase.get(i + 1);
            // 같은게 하나라도 있으면 안된다.
            if (x1.i == x2.i || x1.i == x2.j || x1.j == x2.i || x1.j == x2.j) {
                continue;
            }
            min = Math.min(min, x2.sum - x1.sum);
            if (min == 0) {
                break;
            }
        }
        System.out.println(min);
    }

    static class Case {
        int i;
        int j;
        int sum;

        public Case(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
