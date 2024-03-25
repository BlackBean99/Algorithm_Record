package org.algorithm.스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int result;
    static int[][] teams;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        teams = new int[n][n];
        result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                teams[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs(n/2개 고르기) size n/2 되면 나머지 n/2개의 점수 합 구해서 차이 구하기
        List<Integer> list = new LinkedList<>();
        list.add(0);
        dfs(0, list);
        System.out.println(result);
    }

    private static void dfs(int idx, List<Integer> objects) {
        if (objects.size() == n / 2) {
            List<Integer> linkTeam = new LinkedList<>();
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (index < objects.size() && i == objects.get(index)) {
                    index++;
                } else {
                    linkTeam.add(i);
                }
            }
            Integer power1 = getPower(objects);
            Integer power2 = getPower(linkTeam);
            result = Math.min(Math.abs(power1 - power2), result);
            return;
        }
        if (idx + 1 < n) {
            // 현재 인덱스를 포함하는 경우
            List<Integer> objectsCopy = new ArrayList<>(objects);
            objectsCopy.add(idx + 1);
            dfs(idx + 1, objectsCopy);
            // 현재 인덱스를 포함하지 않는 경우
            dfs(idx + 1, objects);
        }
    }

    private static Integer getPower(List<Integer> linkTeam) {
        int total = 0;
        for (int i = 0; i < linkTeam.size() - 1; i++) {
            for (int j = i + 1; j < linkTeam.size(); j++) {
                total += teams[linkTeam.get(i)][linkTeam.get(j)];
                total += teams[linkTeam.get(j)][linkTeam.get(i)];
            }
        }
        return total;
    }
}
