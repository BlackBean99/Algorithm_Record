package org.algorithm.KB과제.Array.ARRAY2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ArrayQ4 {
    static String[] subjects = {"국어", "영어", "수학", "컴퓨터", "회화"};
    static int[][] scores;
    public static void main(String[] args) {
        initAnswer();
        printScore();
        int sameScoreCount = 0;
        for (int i = 0; i < scores[0].length; i++) {
            // 1학기 성적과 2학기 성적이 동일한 경우 count++
            if(scores[0][i] == scores[1][i]){
                sameScoreCount++;
            }
        }
        System.out.println("1학기와 2학기 성적이 동일한 과목 수: " + sameScoreCount);

        int improvedScoreCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < scores.length; i++) {
            // 1학기에 비해 성적이 오른 과목 수
            if(scores[0][i] < scores[1][i]){
                improvedScoreCount++;
                sb.append(subjects[i] + " ");
            }
        }
        System.out.println("1학기에 비해 성적이 오른 과목 수: " + improvedScoreCount);

        System.out.println("1학기에 비해 성적이 오른 과목: " + sb);

    }

    private static void printScore() {
        for (int i = 0; i < 2; i++) {
            System.out.println(i+1 + "학기 성적: " + Arrays.toString(scores[i]));
        }
    }

    private static void initAnswer() {
        scores = new int[5][2];
        scores[0] = new int[]{44, 66, 22, 99, 100};
        // array deep copy
        scores[1] = scores[0].clone();
        // 첫번째는 22, 세번째는 88로 변경
        scores[1][0] = 22;
        scores[1][2] = 88;
    }
}
