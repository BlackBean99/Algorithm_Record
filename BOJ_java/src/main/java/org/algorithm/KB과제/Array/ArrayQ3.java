package org.algorithm.KB과제.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQ3 {
    static int[] students;
    static Scanner sc;
    public static void main(String[] args) {
        System.out.println("---------------------------------------\n1.학생  | 2.점수 입력 | 3.점수리스트 | 4.분석 | 5.종료\n---------------------------------------");
        sc = new Scanner(System.in);
        int command =0;
        while(command != 5){
            command = getCommand();
            switch (command) {
                case 1:
                    writeStudentSize();
                    break;
                case 2:
                    writeScores();
                    break;
                case 3:
                    printScores();
                    break;
                case 4:
                    printStatistics();
                    break;
                default:
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    private static void printStatistics() {
        System.out.println("최고 점수 : " +  Arrays.stream(students).max().getAsInt());
        System.out.println("평균 점수 : " +  getMeanScore());
    }

    private static Integer getMeanScore() {
        return Arrays.stream(students).sum() / students.length;
    }

    private static void printScores() {
        for (int i = 0; i < students.length; i++) {
            System.out.println("scores[" + i + "]: " + students[i]);
        }
    }

    private static void writeScores() {
        for (int i = 0; i < students.length; i++) {
            System.out.print("scores[" + i + "]: ");
            int score = sc.nextInt();
            students[i] = score;
        }
    }

    private static void writeStudentSize() {
        System.out.print("학생수> ");
        int studentSize = sc.nextInt();
        students = new int[studentSize];
    }

    private static int getCommand() {
        System.out.print("선택> ");
        int command = sc.nextInt();
        return command;
    }


}
