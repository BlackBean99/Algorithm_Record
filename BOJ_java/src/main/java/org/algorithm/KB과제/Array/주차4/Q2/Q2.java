package org.algorithm.KB과제.Array.주차4.Q2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("3 초과인 데이터 들만 모은 list");
        List<Integer> collect = numbers.stream().filter(x -> x > 3).collect(Collectors.toList());
        for(Integer i : collect){
            System.out.print(i + " " );
        }
        System.out.println();
        // print 한칸간격으로 전부 출력
        System.out.println("10 을 곱해 출력");
        List<Integer> collect1 = numbers.stream().map(x -> x * 10).collect(Collectors.toList());
        for(Integer i : collect1){
            System.out.print(i + " " );
        }
    }

}
