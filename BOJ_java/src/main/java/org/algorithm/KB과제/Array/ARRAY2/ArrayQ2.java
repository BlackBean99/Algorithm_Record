package org.algorithm.KB과제.Array.ARRAY2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayQ2 {

    static String[][] menu;
    static int[] orderCounts;
    public static void main(String[] args) throws IOException {
        initMenu();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer command = Integer.MAX_VALUE;
        while(command != 0){
            System.out.println("주문할 상품을 선택하세요 (1: 샌드위치, 2: 바게트, 0: 주문 종료): ");
            command = Integer.parseInt(br.readLine());
            if(command == 0){
                break;
            }
            System.out.println("선택한 상품: " + menu[command-1][0] + "\n" + "주문할 수량을 입력하세요: ");
            int orderCount = Integer.parseInt(br.readLine());
            orderCounts[command - 1] += orderCount;
            printCurrentPrice();
        }
        printTotalPrice();
    }

    private static void printTotalPrice() {
        System.out.println("최종 주문 내역:");
        for (int i = 0; i < 2; i++) {
            System.out.println(menu[i][0] + ": " + orderCounts[i] + "개");
        }
        System.out.println("총 주문 금액: " + (
            orderCounts[0] * Integer.parseInt(menu[0][1]) + orderCounts[1] * Integer.parseInt(menu[1][1])) + "원");
    }
    private static void printCurrentPrice() {
        System.out.println("현재 주문 내역:");
        for (int i = 0; i < 2; i++) {
            System.out.println(menu[i][0] + ": " + orderCounts[i] + "개");
        }
        int currentPrice = orderCounts[0] * Integer.parseInt(menu[0][1]) + orderCounts[1] * Integer.parseInt(menu[1][1]);
        System.out.println("현재 주문 금액: " + currentPrice + "원");
    }

    private static void initMenu() {
        menu = new String[][]{
            {"샌드위치", "2000"},
            {"바게트", "3500"},
        };
        orderCounts = new int[2];
    }
}
