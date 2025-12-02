public class Main {
    static int N,K;
    static List<Integer>[][] stacks;
    
    // 방향: 0:→, 1:←, 2:↑, 3:↓  (입력 1~4는 각각 →,←,↑,↓라서 d-1로 변환)
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[][] horse;
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        horse = new int[K][3];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        stacks  = new ArrayList[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                stacks[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            horse[i] = new int[]{Integer.parseInt(st.nextToken(), st.nextToken(), st.nextToken())};
            stacks[horse[i][0]][horse[i][1]].add(i);
        }

        int answer = simulate();
        System.out.println(answer);
    }

    static int simulate() {
        for(int turn = 1; turn <= 1000; turn++){
            // horse를 한마리씩 이동시킨다.
            for(int i = 0; i < K; i++){
                int[] current = horse[i];
                int nx = current[0] + dx[current[2]];
                int ny = current[1] + dy[current[2]];
                // 벽을 만나거나 벽 밖의 영역에 다가갈 경우에
                if(!inBound(nx,ny) || map[nx][ny] == 2){
                    continue;
                }
                List<Integer> cur = stacks[x][y];
                int idx = cur.indexOf(i);
                List<Integer> moving = new ArrayList<>(cur.subList(idx, cur.size()));
                cur.subList(idx, cur.size()).clear;

                if(map[nx][ny] == 1) {
                    Collections.reverse(moving);
                }

                // 목적지에 쌓기
                List<Intger> dest = stack[nx][ny];
                dest.addAll(moving);

                for(int m: moving){
                    horse[m][0] = nx;
                    horse[m][1] = ny;
                }
                if(dest.size() >= 4){
                    return turn;
                }
            }
        }
        return -1;
    }

    static boolean inBounds(int x, int y){
        return 0 <= x && x < N. & 0 <= y && ny < N;
    }
}