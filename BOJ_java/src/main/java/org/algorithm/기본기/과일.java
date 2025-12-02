import java.util.*;

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
        System.out.println("testCase3 : " + simulate(fruit3, k3) + "/ result : " + result3);
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

        // 큐에 초기 상태 (index=0, count=0, flavor=0)
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 0, 0));

        while(!queue.isEmpty()){
            State cur = queue.poll();

            // k개 골랐으면 결과 갱신
            if(cur.count == k){
                answer = Math.max(answer, Integer.bitCount(cur.combined));
                continue;
            }

            // 끝까지 다 보면 스킵
            if(cur.index == n) continue;

            // 1. 현재 과일 선택
            queue.add(new State(
                cur.index + 1,
                cur.count + 1,
                cur.combined | mask[cur.index]
            ));

            // 2. 현재 과일 선택 안 함
            queue.add(new State(
                cur.index + 1,
                cur.count,
                cur.combined
            ));
        }

        return answer;
    }

    static class State {
        int index;    // 현재 과일 위치
        int count;    // 지금까지 고른 개수
        int combined; // flavor bitmask

        State(int index, int count, int combined){
            this.index = index;
            this.count = count;
            this.combined = combined;
        }
    }
}
