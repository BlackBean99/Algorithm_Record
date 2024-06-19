package org.algorithm.KB과제.Array.ARRAY2;

import java.util.Random;
import java.util.stream.Stream;

public class ArrayQ3 {
    static int[] correctAnswers;
    static int[] myAnswers;
    public static void main(String[] args) {
        initAnswer();
        int score = 0;
        System.out.println("Index\tCorrect Answer\tMy Answer");
        for (int i = 0; i < 1000; i++) {
            System.out.println(String.format("%d\t\t\t%d\t\t\t\t\t\t\t\t%d", i, correctAnswers[i], myAnswers[i]));
            if (correctAnswers[i] == myAnswers[i]) {
                score++;
            }
        }
        System.out.println("맞춘 개수: " + score);
    }

    private static void initAnswer() {
        Random random = new Random();
        correctAnswers = new int[1000];
        myAnswers = new int[1000];

        Stream.iterate(0, i -> i + 1).limit(1000).parallel().forEach(i -> {
            correctAnswers[i] = random.nextInt(0, 4) + 1;
            myAnswers[i] = random.nextInt(0, 4) + 1;
        });
    }
}
