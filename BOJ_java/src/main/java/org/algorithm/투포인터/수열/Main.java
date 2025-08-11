package org.algorithm.투포인터.수열;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = k - 1;

        int answer = 0;
        int max = 0;
        // init;
        for(int i =0; i < k; i++) {
            answer += arr[i];
        }
        max = answer;
        // two pointer
        while(right != n - 1) {
            right++;
            max += arr[right];
            max -= arr[left];
            left++;
            answer = Math.max(answer, max);
        }   
        System.out.println(answer);
    }
}