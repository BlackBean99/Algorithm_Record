package org.algorithm.구현.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());
        if (truth == 0) {
            System.out.println(m);
            return;
        }
        answer = m;
        // 진실을 알고 있는 사람
        Set<Integer> truths = new HashSet<>();
        for (int i = 0; i < truth; i++) {
            truths.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer>[] party = new ArrayList[m];
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            boolean flag = false;
            for (int j = 0; j < num; j++) {
                int people = Integer.parseInt(st.nextToken());
                if (truths.contains(people)) {
                    flag = true;
                    visited[i] = true;
                }
                list.add(people);
            }
            party[i] = list;
            if (flag) {
                truths.addAll(list);
                answer--;
            }
        }

        while (true) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    continue;
                }
                for (int value : party[i]) {
                    if (truths.contains(value)) {
                        visited[i] = true;
                        truths.addAll(party[i]);
                        answer--;
                        count++;
                        break;
                    }
                }
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(answer);
    }
}
