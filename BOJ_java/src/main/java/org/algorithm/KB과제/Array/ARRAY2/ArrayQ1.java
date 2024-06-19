package org.algorithm.KB과제.Array.ARRAY2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayQ1 {
    static String[][] movie;
    public static void main(String[] args) throws IOException {
        movie = new String[5][5];
        initMovie();

        System.out.println("네이버 시리즈온 실시간 영화 목록:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ". " + movie[i][0] + " - 조희수: " + movie[i][1] + "원");
        }
        System.out.println("정보를 확인하고 싶은 영화 번호를 선택하세요 (1-5):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(br.readLine());
        System.out.println("선택한 영화: " + movie[index - 1][0]);
        System.out.println("조희수: " + movie[index - 1][1] + "원");

    }

    private static void initMovie() {
        movie = new String[][]{
            {"Quite Place", "15,000"},
            {"Avengers: Endgame", "23,000"},
            {"Inception", "18,000"},
            {"Parasite", "21,000"},
            {"Interstellar", "19,000"}
        };
    }
}
