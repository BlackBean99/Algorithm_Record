package org.algorithm.구현.경사로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int l;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        l = Integer.parseInt(s[1]);
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (calRow(i)) count++; // i번째 열 확인
            if (calCol(i)) count++; // i번째 행 확인
        }
        System.out.println(count);
    }

    public static boolean calRow(int row) {
        boolean[] isIncline = new boolean[n]; // 경사면 설치 여부를 확인하는 배열

        for (int i = 0; i < n - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];

            if (diff > 1 || diff < -1) return false; // 높이차 1 초과하므로 false
            else if (diff == -1) { // 다음 계단이 한 계단 높다
                for (int j = 0; j < l; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    isIncline[i - j] = true; // 경사면 설치
                }
            } else if (diff == 1) { // 다음 계단이 한 계단 낮다
                for (int j = 1; j <= l; j++) { // 내려가는 경사로를 설치할 수 있는지 확인한다.
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    isIncline[i + j] = true; // 경사면 설치
                }
            }
        }
        return true;
    }

    public static boolean calCol(int col) {
        boolean[] isIncline = new boolean[n]; // 경사면 설치 여부를 확인하는 배열

        for (int i = 0; i < n - 1; i++) {
            int diff = map[i][col] - map[i + 1][col];

            if (diff > 1 || diff < -1) return false; // 높이차 1 초과하므로 false
            else if (diff == -1) { // 다음 계단이 한 계단 높다
                for (int j = 0; j < l; j++) { // 올라가는 경사로를 설치할 수 있는지 확인한다.
                    if (i - j < 0 || isIncline[i - j]) return false;
                    if (map[i][col] != map[i - j][col]) return false;
                    isIncline[i - j] = true; // 경사면 설치
                }
            } else if (diff == 1) { // 다음 계단이 한 계단 낮다
                for (int j = 1; j <= l; j++) { // 내려가는 경사로를 설치할 수 있는지 확인한다.
                    if (i + j >= n || isIncline[i + j]) return false;
                    if (map[i][col] - 1 != map[i + j][col]) return false;
                    isIncline[i + j] = true; // 경사면 설치
                }
            }
        }
        return true;
    }
}
