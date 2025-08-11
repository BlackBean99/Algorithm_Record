package org.algorithm.KB과제.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.random.RandomGenerator;

public class ArrayQ1 {

//    1.   랜덤한 값 1부터 100사이의 값을 20개 만들어 배열에 넣어 출력
//2.   배열에 들어있는 값의 최대값을 찾아 출력
//3.   배열에 들어있는 값 중 최대값이 들어있는 위치를 출력
//4.   배열에 있는 값들을 오름차순으로 정렬
//5. 오름차순으로 정렬한 값들을 내림차순으로 정렬하기 위해 위치를 변경(Reverse)
//6.   값들의 중복이 제거된 값들의 목록과 개수를 출력
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = RandomGenerator.getDefault().nextInt(0, 200);
        }
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        System.out.println("Maximum value: " + arr[maxIndex]);
        System.out.println("Index of maximum value: " + maxIndex);

        Arrays.sort(arr);
        System.out.println("Array in ascending order: " + Arrays.toString(arr));
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrInteger, Collections.reverseOrder());
        System.out.println("Array in descending order: " + Arrays.toString(arrInteger));

        // make arr distinct arr[]
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n - 1];
        int[] distinctArr = new int[j];
        for (int i = 0; i < j; i++) {
            distinctArr[i] = arr[i];
        }
        System.out.println("Distinct values: " + Arrays.toString(distinctArr));
        System.out.println("Count of unique values: " + j);

    }


}
