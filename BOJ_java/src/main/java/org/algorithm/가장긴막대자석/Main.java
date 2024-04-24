package org.algorithm.가장긴막대자석;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();
        Stack<Integer> n = new Stack<>(), s = new Stack<>();
        ArrayList<Integer> v = new ArrayList<>();
        boolean flag = false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'N') {
                n.push(1);
                // S를 만나면
                if (!flag) {
                    v.add(s.size());
                    s.clear();
                }
                flag = true;
            } else if (S.charAt(i) == 'S') {
                s.push(1);
                // N을 만나면
                if (flag) {
                    v.add(n.size());
                    n.clear();
                }
                flag = false;
            }
        }

        if (flag) {
            v.add(n.size());
        } else {
            v.add(s.size());
        }

        v.add(0);

        int res = 0;

        for (int i = 1; i < v.size(); i++) {
            res = Math.max(res, 2 * Math.min(v.get(i - 1), v.get(i)));
        }

        System.out.println(res);
    }
}
