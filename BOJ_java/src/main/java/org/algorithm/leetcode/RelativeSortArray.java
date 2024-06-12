package org.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] integers = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(integers));
        arr1 = new int[]{28,6,22,8,44,17};
        arr2 = new int[]{22,28,8,6};
        integers = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(integers));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int j : arr1) {
            if (hm.containsKey(j)) {
                hm.put(j, hm.get(j) + 1);
            } else {
                hm.put(j, 1);
            }
        }
        int[] ans = new int[arr1.length];
        int cnt=0;
        for (int j : arr2) {
            while (hm.get(j) > 0) {
                ans[cnt] = j;
                cnt++;
                hm.put(j, hm.get(j) - 1);
            }
            hm.remove(j);
        }
        int[] remaining = new int[arr1.length-cnt];
        int index = 0;
        for (int j : arr1) {
            if (hm.containsKey(j)) {
                while (hm.get(j) > 0) {
                    remaining[index] = j;
                    index++;
                    hm.put(j, hm.get(j) - 1);
                }
                hm.remove(j);
            }
        }
        Arrays.sort(remaining);
        for (int j : remaining) {
            ans[cnt] = j;
            cnt++;
        }
        return ans;
    }
}
