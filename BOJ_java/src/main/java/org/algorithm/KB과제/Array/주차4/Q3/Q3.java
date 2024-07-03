package org.algorithm.KB과제.Array.주차4.Q3;

import java.util.Arrays;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "Hi", "smile");
        System.out.println("1. 각 요소를 모두 대문자로 변경한 후, 글자 수가 4를 초과하는 데이터들의 list를 생성해 출력하세요 .");
        words.stream().filter(x -> x.length() > 4).map(x -> x.toUpperCase()).forEach(System.out::println);
        System.out.println("2. 각 요소에 대해 “님\"을 붙인 후, list를 생성해 출력하세요 .");
        words.stream().map(x -> x + "님").forEach(System.out::println);
    }

}
