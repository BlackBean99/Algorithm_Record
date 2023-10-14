package 숫자카드나누기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arrayA1 = new int[]{10, 17};
        int[] arrayB1 = new int[]{5, 20};
        int answer1 = 0;
        int result1 = new Solution().solution(arrayA1, arrayB1);
        PRINT_RESULT(1, result1, answer1);

        int[] arrayA2 = new int[]{10, 20};
        int[] arrayB2 = new int[]{5, 17};
        int answer2 = 10;
        int result2 = new Solution().solution(arrayA2, arrayB2);
        PRINT_RESULT(2, result2, answer2);

        int[] arrayA3 = new int[]{14, 35, 119};
        int[] arrayB3 = new int[]{18, 30, 102};
        int answer3 = 7;
        int result3 = new Solution().solution(arrayA3, arrayB3);
        PRINT_RESULT(3, result3, answer3);
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

    public List<Integer> getDividedNumber(int[] array) {
//        최대 공약수를 찾으면 된다.
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        List<Integer> dividedNumbers = new LinkedList<>();
        for(int i = 2; i < max+1; i++){
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] % i == 0) {
                    count++;
                }
            }
            if(count == array.length) dividedNumbers.add(i);
        }
        return dividedNumbers;
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> listA = getDividedNumber(Arrays.stream(arrayA).distinct().toArray());
        List<Integer> listB = getDividedNumber(Arrays.stream(arrayB).distinct().toArray());

        for(int i=listA.size()-1;i>=0;i--) {
            int a = listA.get(i);

            Boolean check = true;
            for(int b : arrayB) {
                if(b%a==0) {
                    check = false;
                    break;
                }
            }
            if(check) {
                answer = a;
                break;
            }
        }

        for(int j=listB.size()-1;j>=0;j--) {
            int b = listB.get(j);

            Boolean check = true;
            for(int a : arrayA) {
                if(a%b==0) {
                    check = false;
                    break;
                }
            }

            if(answer<b && check) {
                answer = b;
                break;
            }
        }
        return answer;
    }

}