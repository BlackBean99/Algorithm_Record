package org.algorithm.외계인의기타연주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        int flat = Integer.parseInt(st.nextToken());

        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 1; i <= line; i++) {
            map.put(i, new Stack<>());
        }
        int count = 0;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            Integer inputLine = Integer.parseInt(st.nextToken());
            Integer inputFlat = Integer.parseInt(st.nextToken());
            Stack<Integer> stack = map.get(inputLine);

            while (!stack.isEmpty() && stack.peek() > inputFlat) {
                stack.pop();
                count++;
            }
            if (stack.empty() || (!stack.isEmpty() && stack.peek() < inputFlat)) {
                stack.push(inputFlat);
                count++;
            }
        }
        System.out.println(count);
    }
}
