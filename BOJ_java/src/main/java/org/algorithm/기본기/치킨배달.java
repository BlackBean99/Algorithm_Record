import java.util.*;
import java.io.*;
class Main{
    static int[][] map;
    List<int[]> houses;
    List<int[]> chickens;
    static int answer, n, m;
    public static void main(String[] args){
        answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(System.in);
        StringTokenizer st = new StringTokenizer(br.readLin());
        n = Integer.parseInt(st.nextToken);
        m = Integer.parseInt(st.nextToken);
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    houses.add(new int[]{i,j});
                } else if(map[i][j] == 2){
                    chickens.add(new int[]{i,j});
                }
            }
        }
        dfs();
        System.out.print(answer);
    }

    // chickens중에 M개를 골라서 거리 계산해서 최적화
    static int dfs(){
        // chickens
        Stack<State> stack = new Stack<>();
        stack.push(new Stack(new ArrayList<>(), 0));
        
        while(!stack.isEmpty()){
            State cur = stack.pop();
            
            if(cur.selected.size() == m){
                answer = Math.min(ansewr, getDistance());
                continue;
            }

            for(int i = cur.start; chickens.size(); i++){
                List<Integer> list = new ArrayList<>(cur.selected);
                list.add(i);
                stack.push(new State(list, i + 1));
            }
        }
    }

    static int getDistance(List<int[]> selected) {
        int sum = 0;
        for(int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for(int[] chick : selected){
                int dist = Math.abs(house[0] - chick[0]) + Math.abs(house[1] - chick[1]);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
    static int dfs(){
        // 스택에는 현재 고른 치킨집 인덱스 리스트를 넣음
        Stack<State> stack = new Stack<>();
        stack.push(new State(new ArrayList<>(), 0));

        while (!stack.isEmpty()) {
            State cur = stack.pop();

            // m개 다 골랐으면 치킨거리 계산
            if (cur.selected.size() == m) {
                answer = Math.min(answer, getDistance(cur.selected));
                continue;
            }

            // 아직 고를 수 있다면 다음 치킨집 후보를 추가
            for (int i = cur.start; i < chickens.size(); i++) {
                List<Integer> nextList = new ArrayList<>(cur.selected);
                nextList.add(i);
                stack.push(new State(nextList, i + 1)); // i+1부터 다음 선택
            }
        }
    }

    // 도시 치킨 거리 계산
    static int getDistance(List<int[]> selected) {
        int sum = 0;
        for (int[] house : houses) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chick : selected) {
                int dist = Math.abs(house[0] - chick[0]) + Math.abs(house[1] - chick[1]);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
        static class State {
        List<Integer> selected;
        int start;

        State(List<Integer> selected, int start) {
            this.selected = selected;
            this.start = start;
        }
    }
}