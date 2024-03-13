package org.algorithm.맥주마시면서_걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int start[] = new int[2];
        int end[] = new int[2];
        int[][] convinent;
        /**
         * 첫번째, 편의점 갯수
         * 2번째, start 좌표
         * 3번째부터 3+n개, n개의 편의점 좌표
         * 마지막, end 좌표
         * */
        for (int i = 0; i < testCase; i++) {

            int convenientNumber = Integer.parseInt(br.readLine());
            convinent = new int[convenientNumber][convenientNumber];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            for (int j = 0; j < convenientNumber; j++) {
                st = new StringTokenizer(br.readLine());
                convinent[j][0] = Integer.parseInt(st.nextToken());
                convinent[j][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            // 편의점을 x좌표 기준으로 정렬. ( 오른쪽으로 갈 것이라 예상 )
            // 1. 오른쪽
            if(start[0] < end[0]){
                Arrays.sort(convinent, Comparator.comparingInt(o -> o[0]));

            } else{  // 2, 왼쪽
                Arrays.sort(convinent, Comparator.comparingInt((int[] o) -> o[0]).reversed());
            }

            // 시작점에서 편의점까지 갈 수 있니?
            if(!isArrived(start, convinent[0])){
                System.out.println("sad");
            }
            // 편의점에서 편의점까지 갈 수 있니?
            boolean isArrivedBetweenConvinent = true;
            for (int j = 0; j < convenientNumber -1 ; j++) {
                if (!isArrived(convinent[j], convinent[j + 1])) {
                    System.out.println("sad");
                    isArrivedBetweenConvinent = false;
                }
            }
            if(!isArrivedBetweenConvinent){
                continue;
            }

            // 편의점엑서 도착지까지 갈 수 있니?
            if(!isArrived(convinent[convenientNumber-1], end)){
                System.out.println("sad");
            }
            System.out.println("happy");
        }
    }

    private static boolean isArrived(int[] start, int[] end) {
        int distance = Math.abs(start[1] - end[1]) + Math.abs(start[0] - end[0]);
        return distance <= 50 * 20 ? true : false;
    }
}
