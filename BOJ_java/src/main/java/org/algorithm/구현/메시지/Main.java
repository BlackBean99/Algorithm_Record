package org.algorithm.구현.메시지;

import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer cnt;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        cnt = Integer.parseInt(br.readLine());
        String[] mans = new String[cnt + 1];
        String[][] letter = new String[cnt + 1][cnt + 1];
        int round = 1;
        while (cnt != 0) {
            for (int i = 0; i < cnt; i++) {
                String[] s = br.readLine().split(" ");
                mans[i] = s[0];
                letter[i] = Arrays.copyOfRange(s, 1, s.length);
            }
            System.out.println(String.format("Round%d", round++));
            process(mans, letter);
            cnt = Integer.parseInt(br.readLine());
            mans = new String[cnt];
            letter = new String[cnt][cnt];
        }
    }

    private static void process(String[] mans, String[][] letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mans.length; i++) {
            for (int j = 0; j < mans.length - 1; j++) {
                if (letter[i][j].equals("N")) {
                    int from = i - j < 0 ? mans.length + (i - j) - 1 : i - j - 1;
                    sb.append(mans[from] + " was nasty about " + mans[i] + "\n");
                }
            }
        }
        System.out.println(sb.toString() == "" ? "Nobody was nasty" : sb.toString());
    }
}
