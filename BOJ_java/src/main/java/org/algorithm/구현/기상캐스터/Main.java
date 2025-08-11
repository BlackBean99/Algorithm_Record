package org.algorithm.구현.기상캐스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static int[][] answer;
    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        answer = new int[h][w];

        for (int i = 0; i < h; i++) {
            Arrays.fill(answer[i], -1);
        }
        int minCloudIdx = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                char c = s.charAt(j);
                if (c == 'c') {
                    minCloudIdx = Math.min(j, minCloudIdx);
                }
                map[i][j] = s.charAt(j);
            }
        }
        int tempCnt = w;
        while (tempCnt-- > 0) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (isCloud(i, j)) {
                        if (answer[i][j] != -1) {
                            continue;
                        }
                        answer[i][j] = w - tempCnt - 1;
                    }
                }
            }
            push();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                sb.append(answer[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void push() {
        for (int i = 0; i < h; i++) {
            for (int j = w - 1; j > 0; j--) {
                map[i][j] = map[i][j - 1];
            }
            map[i][0] = '.';
        }
    }

    private static boolean isCloud(int x, int y) {
        return map[x][y] == 'c';
    }
}
