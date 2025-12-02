import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class Main {
        public static void main(String[] args){
        String[] fruit1 = {"1100", "0110", "0011", "1100"};
        String[] fruit2 = {"100", "010", "001"};
        String[] fruit3 = {"111", "101", "110", "011"};

        int k1 = 2;
        int k2 = 2;
        int k3 = 3;

        int result1 = 4;
        int result2 = 2;
        int result3 = 3;

        System.out.println("testCase1 : " + simulate(fruit1, k1) + "/ result : " + result1);
        System.out.println("testCase2 : " + simulate(fruit2, k2) + "/ result : " + result2);
        System.out.println("testCase2 : " + simulate(fruit3, k3) + "/ result : " + result3);
        }
        static int simulate(String[] fruit, int k){
            int n = fruit.length;
            int len = fruit[0].length();

            // 문자열을 비트마스크로 변환
            int[] mask = new int[n];
            for(int i = 0; i < n; i++){
                int bit = 0;
                for(int j = 0; j < len; j++){
                    if(fruit[i].charAt(j) == '1'){
                        bit |= (1 << j);
                    }
                }
                mask[i] = bit;
            }

            int answer = 0;
            Stack<State> stack = new Stack<>();
            stack.push(new State(new ArrayList<>(), 0));

            while(!stack.isEmpty()){
                State cur = stack.pop();

                // k개를 다 고르면 flavor 계산
                if(cur.selected.size() == k){
                    int sum = 0;
                    for(Integer idx : cur.selected){
                        sum |= mask[idx];
                    }
                    answer = Math.max(answer, Integer.bitCount(sum));
                    continue;
                }

                // 더 이상 고를 게 없으면 스킵
                if(cur.start == n) continue;

                // 1. 현재 index 과일 선택
                List<Integer> with = new ArrayList<>(cur.selected);
                with.add(cur.start);
                stack.push(new State(with, cur.start + 1));

                // 2. 현재 index 과일 선택 안 함
                stack.push(new State(new ArrayList<>(cur.selected), cur.start + 1));
            }
            return answer;
        }

    static class State{
        List<Integer> selected; // 선택한 과일 index
        int start;              // 다음으로 볼 시작 index

        State(List<Integer> selected, int start){
            this.selected = selected;
            this.start = start;
        }
    }
}