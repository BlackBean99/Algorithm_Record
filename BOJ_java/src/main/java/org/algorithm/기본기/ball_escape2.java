class Main{

// 5 5
// #####
// #..B#
// #.#.#
// #RO.#
// #####
    static int n,m;
    static int redX, redY, blueX, blueY;
    static char[][] map;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static int answer;
    static boolean[][][][] visited;
    public static void main(String[] args){
        answer = Integer.MAX_VALUE;
        visited = new boolean[n][m][n][m];
        BufferedReader br = new BufferedReader(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        simulate();
    }

    static void simulate(){
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(redX, redY, blueX, blueY, 0));
        while(!queue.isEmpty()){
            State cur = queue.poll();
            for(int dir = 0; dir < 4; dir++){
                int nextBx = cur.bx + dx[dir];
                int nextBy = cur.by + dy[dir];
                int nextRx = cur.rx + dx[dir];
                int nextRy = cur.ry + dy[dir];
                // red moving
                while(inBound(nextRx, nextRy)) {
                    nextRx += dx[dir];
                    nextRy += dy[dir];
                }
                
                // blue moving
                while(inBound(nextBx, nextBy)){
                    nextBx = cur.bx + dx[dir];
                    nextBy = cur.by + dy[dir];
                }

                // 1. 방문한 적이 있으면 패스
                If(!visited[nextRx][nextRy][nextBx][nextBy]){
                    continue;
                }
                // 공이 겹칠 경우
                if(nextBx == nextRx && nextBy == nextRy){
                    // dir에 따라서 위치 조정
                    switch(dir){
                        case 0:
                            if(cur.rx  < cur.bx) cur.rx--;
                            else cur.bx--;
                            break;
                        case 1:
                            if(cur.ry < cur.by) cur.ry--;
                            else cur.by--;
                            break;
                        case 2:
                            if(cur.rx < cur.bx) cur.bx++;
                            else cur.rx++;
                            break;
                        case 3:
                            if(cur.ry < cur.by) cur.by++;
                            else cur.ry++;
                            break;
                    }
                }
                // 2. 파란 공이 먼저 들어간 경우
                if(nextBx == holeX && nextBy == holeY){
                    continue;
                }
                // 3. 빨간 공이 먼저 들어간 경우
                if(nextBx == holeX && nextBy == holeY){
                    answer = Math.min(answer, cur.count + 1);
                    continue;
                }
                // 4. 아직 들어가지 않은 경우
                if(!visited[nextRx][nextRy][nextBx][nextBy]){
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.add(new State(nextRx,nextRy,nextBx,nextBy,count+1));
                }
            }
            if(cur.count > 10){
                answer = Math.min(answer, cur.count + 1);
                continue;
            }
        }            
            
        return answer > 0 ? answer : -1;
    }
    static class State{
        int bx,by,rx,ry,count;
        State(int rx,int ry, int bx, int by, int count){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
}