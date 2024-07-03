package org.algorithm.KB과제.Array.주차4.Q1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String command = null;
    public static void main(String[] args) throws IOException {
        Fruit apple = ObjectFactory.getFruit("apple");
        Fruit banana = ObjectFactory.getFruit("banana");
        Fruit ice = ObjectFactory.getFruit("ice");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        command = getInput(br);

        while(command != "exit") {
//            if(command == "Apple") {
//                apple.run();
//            } else if(command == "Banana") {
//                banana.run();
//            } else if(command == "Ice") {
//                ice.run();
//            } else {
//                System.out.println("잘못된 입력입니다.");
//            }
            switch (command) {
                case "Apple":
                    apple.run();
                    break;
                case "Banana":
                    banana.run();
                    break;
                case "Ice":
                    ice.run();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
            command = getInput(br);
        }
        apple.run();
        banana.run();
        ice.run();
    }

    private static String getInput(BufferedReader br) throws IOException {
        System.out.println("어떤 객체를 생성하시겠습니까? (Apple, Banana, Ice): ");
        return String.valueOf(br.readLine());
    }

}
