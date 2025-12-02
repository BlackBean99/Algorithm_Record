package org.algorithm.이분탐색.구간나누기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        int[] nums = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }

<<<<<<< HEAD
        int left = 0;
        int right = max - min;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(canDvideByMid(mid, m, nums)) {
=======

        int left = 0;
        int right = max - min;
        while(left <=right){
            int mid = (left + right) / 2;
            if(canDevidedByMid(mid, m, nums)){
>>>>>>> main
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

<<<<<<< HEAD
    public static boolean canDvideByMid(int mid, int m, int[] nums) {
        int countSet = 1;

        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if((max - min) > mid) {
                min = nums[i];
                max = nums[i];
                countSet++;
                if(countSet > m) return false;
=======
    public static boolean canDevidedByMid(int mid, int m, int[] nums){
        int count = 0;
        int min = nums[0];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if(max - min > mid){
                count++;
                min = nums[i];
                max = nums[i];
                if(count > m) return false;
>>>>>>> main
            }
        }
        return true;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
