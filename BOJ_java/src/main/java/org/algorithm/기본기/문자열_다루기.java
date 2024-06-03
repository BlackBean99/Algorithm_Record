package org.algorithm.기본기;

import java.util.Arrays;

public class 문자열_다루기 {
    public static void main(String[] args){
        //1.  여러 문자중 특정 문자만 변경해보자
/*        String str = "2XXXX";
        int nthX = 3;
        char newChar = 'Y';

        String result = changeNthX(str, nthX, newChar);
        System.out.println(result);*/


//        2. String 정렬해보기
        String a = "abasfqagdegulijbnw";
        char[] charArray = a.toCharArray();
        String result = sortCharArray(charArray);
        System.out.println("result = " + result);

    }

    private static String sortCharArray(char[] charArray) {
        Arrays.sort(charArray);
        return new String(charArray);
    }

    private static String changeNthX(String str, int nthX, char newChar) {
        int count = 0;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'X') {
                count++;
                if (count == nthX) {
                    sb.setCharAt(i, newChar);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
