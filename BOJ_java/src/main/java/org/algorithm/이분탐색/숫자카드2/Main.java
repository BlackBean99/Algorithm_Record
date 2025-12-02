package org.algorithm.이분탐색.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] targets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        targets = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(getUpperBound(targets[i]) - getLowerBound(targets[i]) + " ");
        }
        System.out.println(sb);
    }

<<<<<<< HEAD
=======
    static int getLowerBound(int target) {
        int lo = 0;
        int hi = arr.length;
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(target < arr[mid]){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
>>>>>>> main
    private static int getLowerBound(int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (target <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
<<<<<<< HEAD
    private static int getUpperBound(int target) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (target < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
=======
>>>>>>> main
}
