package org.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        Integer[] integers = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(integers));
        arr1 = new int[]{28,6,22,8,44,17};
        arr2 = new int[]{22,28,8,6};
        integers = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(integers));
    }
    public static Integer[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> temp = new LinkedList<>();
        List<Integer> answer = new LinkedList<>();
        boolean[] visited = new boolean[arr1.length + 1];

        for(int i = 0; i < arr2.length; i ++){
            for(int j = 0; j < arr1.length; j++){
                if (visited[j]) {
                    continue;
                }
                if(arr2[i] == arr1[j]){
                    answer.add(arr1[j]);
                    visited[j] = true;
                }
            }
        }
        for (int i = 0; i < visited.length-1; i++) {
            if(visited[i] == false){
                temp.add(arr1[i]);
            }
        }
        temp.sort((a, b) -> a - b);
        answer.addAll(temp);
        Integer[] array = answer.toArray(new Integer[answer.size()]);

        return array;
    }
}
