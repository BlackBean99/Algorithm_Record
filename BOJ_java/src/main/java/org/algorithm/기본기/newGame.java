public class Main{
    static int[][] map;
    static int[][] horses;
    static int n, k;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int[] reverseDir = new int[]{1,0,3,2};
    static List<Integer>[][] stacks;

    public static void main(String[] args){
        BufferedReader br = new BufferedReader(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        stacks = new ArrayList[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                stacks[i][j] = new ArrayList<>();
            }
        }
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            horses[i][0] = Integer.parseInt(st.nextToken());
            horses[i][1] = Integer.parseInt(st.nextToken());
            horses[i][2] = Integer.parseInt(st.nextToken()) - 1;
        }

        int round = 0;
        while(round <= 1000){
            for(int i = 0; i < horses.length; i++){
                curX = horses[i][0];
                curY = horses[i][1];
                curDir = horses[i][2];
                nX = curX + dx[curDir];
                nY = curY + dy[curDir];  
                if(inBound(nX,nY) || map[nX][nY] == 2){
                    curDir = reverseDir[curDir];
                    nX = curX + dx[curDir];
                    nY = curY + dy[curDir];
                    if(inBound(nX,nY) || map[nX][nY] == 2){
                        continue;
                    }
                }

                // 움직일 애들 선정
                List<Integer> cur = stacks[curX][curY];
                int idx = stacks[nX][nY].indexOf(i);
                List<Integer> moving = stacks[curX][curY].subList(idx, stacks[curX][curY].size());
                cur.subList(idx, moving.size()).clear();

                if(map[nX][nY] == 1){
                    Collections.reverse(cur);
                }

                horses[i][0] = nX;
                horses[i][1] = nY;
                horses[i][2] = curDir;
                
                // 파란색은 위에서 처리함
                List<Integer> destination = stacks[nX][nY];
                destination.addAll(cur);

                if(destination.size() >= 4){
                    return round;
                }
            }
            round++;
        }
    return -1;
}