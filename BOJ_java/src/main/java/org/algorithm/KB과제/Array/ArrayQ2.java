package org.algorithm.KB과제.Array;

import java.sql.Array;
import java.util.Arrays;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

public class ArrayQ2 {
    static int[] arr1, arr2;


    public static void main(String[] args) {
        arr1 = new int[10];
        arr2 = new int[10];
//                 * 1.   두 개의 정수 배열을 생성
//            * 첫 번째 배열은 1에서 50 사이의 랜덤 값 10개
//            * 두 번째 배열은 51에서 100 사이의 랜덤 값 10개
        for (int i = 0; i < 10; i++) {
            arr1[i] = RandomGenerator.getDefault().nextInt(1, 50);
            arr2[i] = RandomGenerator.getDefault().nextInt(51, 100);
        }

        System.out.println("배열 1: " + Arrays.toString(arr1));
        System.out.println("배열 2: " + Arrays.toString(arr2));



        int[] arr3 = new int[20];
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        int[] distinctArray = Arrays.stream(arr3).distinct().toArray();
        System.out.println("중복 값 제거된 배열: " + Arrays.toString(distinctArray));
        // 3. 중복 값이 제거된 배열을 오름차순으로 정렬
        Arrays.sort(distinctArray);
        System.out.println("오름차순 정렬된 배열: " + Arrays.toString(distinctArray));
        //  4. 정렬된 배열에서 최대값과 최소값을 찾아 출력
        System.out.println("최대값: " + distinctArray[distinctArray.length-1]);
        System.out.println("최소값: " + distinctArray[0]);
        //  5.최대값과 최소값의 위치(인덱스)를 출력
        System.out.println("최대값의 위치: " + (distinctArray.length-1));
        System.out.println("최소값의 위치: " + 0);

    }

}
