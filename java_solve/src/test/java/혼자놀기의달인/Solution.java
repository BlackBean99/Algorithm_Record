package 혼자놀기의달인;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int fuel = 19;
        int[] powers = new int[]{40, 30, 20, 10};
        int[] distances = new int[]{1000, 2000, 3000, 4000};
        int expectedResult = 40;
        int result1 = new Solution().solution(fuel, powers, distances);
        PRINT_RESULT(1, result1, expectedResult);
    }
    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public static int solution(int fuel, int[] powers, int[] distances) {
        int answer = 0;
        LinkedList<Machine> machines = new LinkedList<>();
        for(int i = 0; i < powers.length; i++){
            machines.add(new Machine(powers[i], distances[i]));
        }
        // power 가 센 순서가 먼저로 정렬
        Collections.sort(machines, (o1, o2) -> o2.power - o1.power);
        int currentFuel = fuel; // 현재 연료량 변수
        int totalTime = 0; // 현재까지 경과한 시간 변수
        int size = machines.size();
        for (Machine machine : machines) {
            // 현재 연료량으로 갈 수 있는 거리
            int possibleDistance = currentFuel * machine.power;
            // 현재 연료량으로 갈 수 있는 거리보다 기계의 거리가 더 길다면
            if (possibleDistance < machine.distance) {
                // 현재 연료량으로 갈 수 있는 거리만큼만 이동
                machine.distance -= possibleDistance;
                totalTime += currentFuel;
                currentFuel = 0;
            } else { // 현재 연료량으로 갈 수 있는 거리가 기계의 거리보다 길다면
                // 기계의 거리만큼 이동
                currentFuel -= machine.distance / machine.power;
                totalTime += machine.distance / machine.power;
                machine.distance = 0;
            }
            // 현재 연료량이 0이라면
            if (currentFuel == 0) {
                // 연료를 충전하고
                currentFuel = fuel;
                // 기계의 거리가 남아있다면
                if (machine.distance > 0) {
                    // 기계의 거리만큼 시간을 추가
                    totalTime += machine.distance / machine.power;
                    machine.distance = 0;
                }
            }
        }

        answer = totalTime; // 최소 시간으로 업데이트
        System.out.println("answer = " + answer);
        return answer;
    }
    public static class Machine{
        int power;
        int distance;
        public Machine(int power, int distance){
            this.power = power;
            this.distance = distance;
        }
    }
}