package org.algorithm.행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[] startList;
    static int[] map;
    static int k,n;
    static int answer;
    public static void findDuplicatePermutations(int k, int n) {
        int[] permutation = new int[k];
        findDuplicatePermutationsUtil(k, n, permutation, 0);

    }

    // Utility function to recursively find duplicate permutations
    private static void findDuplicatePermutationsUtil(int k, int n, int[] permutation, int index) {
        if (index == k) {
            if (Arrays.stream(permutation).sum() == n && hasDuplicates(permutation)) {
                startList = new int[k];
                startList[0] = 0;
                for (int i = 1; i < k; i++) {
                    startList[i] = permutation[i - 1] + startList[i - 1];
                }
                calcMinCost(startList, k);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            permutation[index] = i;
            findDuplicatePermutationsUtil(k, n, permutation, index + 1);
        }
    }

    private static void calcMinCost(int[] startList, int k) {
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            if(startList[i+1] - startList[i] == 1){
                continue;
            } else {
                sum += (map[startList[i + 1] - 1] - map[startList[i]]);
            }

        }
        if (startList[k - 1] == n-1) {

        } else {
            sum += map[startList[k - 1]] + map[k - 1];
        }
        answer = Math.min(answer, sum);
    }

    // Function to check if an array has duplicates
    private static boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        map = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        findDuplicatePermutations(k, n);
        System.out.println(answer);
    }
}