package org.algorithm.leetcode;

import java.util.Stack;

public class ReverseInteger {

    public static void main(String[] args) {
        long input = 9646324351L;
        System.out.println(reverse(input));
    }
    public static int reverse(long x) {
        // 123 -> 321
        Stack<String> stack = new Stack<>();
        String s = String.valueOf(x);
        char[] charArray = s.toCharArray();
        for (char a : charArray) {
            if(a == '-') continue;
            stack.add(String.valueOf(a));
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String reverse = stack.pop();
            sb.append(reverse);
        }
        int i = Integer.parseInt(sb.toString());
        if(x < 0){
            i *= -1;
        }
        return i;
    }

    public int reverse(int x) {
        long num = 0;
        int y = Math.abs(x);
        while (y > 0) {
            int rem = y % 10;
            num = num * 10 + rem;
            y = y / 10;
        }
        if(Integer.MAX_VALUE<num)return 0;
        if(x<0)return -1*(int)num;
        else
            return (int) num;
    }
}
