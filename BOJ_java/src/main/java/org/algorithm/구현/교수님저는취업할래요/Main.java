package org.algorithm.구현.교수님저는취업할래요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        StringTokenizer st;
        int[] professor = new int[2];
        int[] me = new int[2];
        List<int[]> friends = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 5) {
                    professor = new int[] {i, j};
                } else if (map[i][j] == 1) {
                    friends.add(new int[] {i, j});
                } else if (map[i][j] == 2) {
                    me = new int[] {i, j};
                }
            }
        }
        if ((me[0] - professor[0]) * (me[0] - professor[0])
                        + (me[1] - professor[1]) * (me[1] - professor[1])
                < 25) {
            System.out.println(0);
            return;
        }
        int minx = Math.min(me[0], professor[0]);
        int maxx = Math.max(me[0], professor[0]);
        int miny = Math.min(me[1], professor[1]);
        int maxy = Math.max(me[1], professor[1]);
        int count = 0;
        for (int[] friend : friends) {
            if (minx <= friend[0] && friend[0] <= maxx && miny <= friend[1] && friend[1] <= maxy) {
                count++;
            }
        }
        System.out.println(count >= 3 ? 1 : 0);
    }
}
