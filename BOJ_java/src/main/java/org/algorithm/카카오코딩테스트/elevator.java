import java.io.*;
import java.util.*;

public class Main {
    static int[][] dist;       // 패널 간 거리
    static int k;
    static int n, m;           // 템플릿의 행, 열
    static int h;              // 층 수
    static int elevX, elevY;   // 엘리베이터 위치 (템플릿 기준)
    static int[][] panels;     // panels[i] = {floor(0-based), row(0-based), col(0-based)}
    static String[] floorTemplate;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // --- 입력 형식 (내가 가정한 형태: h, n, n줄(템플릿), k, k줄(panels 1-based), seqCount, seqs) ---
        h = Integer.parseInt(br.readLine().trim());        // 층 수
        n = Integer.parseInt(br.readLine().trim());        // 템플릿 행 수
        floorTemplate = new String[n];
        for (int i = 0; i < n; i++) floorTemplate[i] = br.readLine();

        m = floorTemplate[0].length();

        // 패널 수
        k = Integer.parseInt(br.readLine().trim());
        panels = new int[k][3];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력이 1-based 라고 가정 -> 0-based로 보정
            int f = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            panels[i][0] = f;
            panels[i][1] = r;
            panels[i][2] = c;
        }

        int seqCount = Integer.parseInt(br.readLine().trim());
        int[][] seqs = new int[seqCount][2];
        for (int i = 0; i < seqCount; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력이 1-based로 들어온다고 가정 -> 0-based로 보정
            seqs[i][0] = Integer.parseInt(st.nextToken()) - 1;
            seqs[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        // 해결
        int result = solve(seqs);
        System.out.println(result);
    }

    static int[] distFromElevator; // 각 패널까지 엘리베이터-평면 거리 (템플릿 BFS 결과 사용)

    public static int solve(int[][] seqs) {
        // 1) 엘리베이터 위치 찾기 (템플릿에서)
        findElevator();

        // 2) 템플릿에서 엘리베이터 출발 2D BFS 한 번 -> 모든 칸까지 거리
        int[][] floorDist = bfsFromElevatorOnTemplate();

        // 3) distFromElevator 채우기 (패널마다)
        distFromElevator = new int[k];
        final int INF = Integer.MAX_VALUE / 4;
        for (int i = 0; i < k; i++) {
            int pr = panels[i][1], pc = panels[i][2];
            int d = floorDist[pr][pc];
            distFromElevator[i] = (d >= INF ? INF : d);
        }

        // 4) 패널 간 거리 테이블 계산
        dist = new int[k][k];
        for (int i = 0; i < k; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < k; i++) {
            dist[i][i] = 0;
            for (int j = i+1; j < k; j++) {
                if (distFromElevator[i] >= INF || distFromElevator[j] >= INF) {
                    dist[i][j] = dist[j][i] = INF;
                } else {
                    int floorMove = Math.abs(panels[i][0] - panels[j][0]); // 층간 이동 비용
                    int val = distFromElevator[i] + distFromElevator[j] + floorMove;
                    dist[i][j] = dist[j][i] = val;
                }
            }
        }

        // 5) 의존관계(시퀀스) 처리 및 DP로 최소 시간 계산
        return processDependencies(seqs);
    }

    // 템플릿에서 엘리베이터 위치 찾기
    static void findElevator() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (floorTemplate[i].charAt(j) == '@') {
                    elevX = i; elevY = j;
                    return;
                }
            }
        }
        // 만약 찾지 못하면 -1 처리 (문제 제약상 반드시 존재해야 함)
        elevX = elevY = -1;
    }

    // 템플릿에서 엘리베이터 출발, 모든 칸까지 거리 계산 (장애물 '#' 고려)
    static int[][] bfsFromElevatorOnTemplate() {
        final int INF = Integer.MAX_VALUE / 4;
        int[][] distGrid = new int[n][m];
        for (int[] row : distGrid) Arrays.fill(row, INF);
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{elevX, elevY, 0});
        vis[elevX][elevY] = true;
        distGrid[elevX][elevY] = 0;
        int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && floorTemplate[nx].charAt(ny) != '#') {
                    vis[nx][ny] = true;
                    distGrid[nx][ny] = d + 1;
                    q.add(new int[]{nx, ny, d + 1});
                }
            }
        }
        return distGrid;
    }

    // 의존관계 기반 DP (비트마스크)
    static int processDependencies(int[][] seqs) {
        final long INF_L = Long.MAX_VALUE / 4;

        // prereqMask[i] : i번 패널을 활성화하기 위해 필요한 패널들의 비트마스크
        int[] prereqMask = new int[k];
        Arrays.fill(prereqMask, 0);
        for(int[] s : seqs){
            int a = s[0], b = s[1];
            prereq[b] |= (1 << a);
        }
        int FULL = (1 << k);
        // mask가 선행된 상태에서 K 를 활성화 시키기 위한 최소화 시간
        // 우리가 원하는 것은 mask = 0 -> k 인 시간
        long[][] dp = new ling[FULL][k];

        // DP 배열: dp[mask][last] = 최소 시간 (mask는 활성화된 패널 집합, last는 마지막으로 활성화한 패널 인덱스)
        for(int mask = 0; mask < FULL; mask++) Arrays.fill(dp[mask], INF_L);

        // 시작 위치: 항상 panels[0] 위치(== 1번 패널 위치)에서 시작(활성화 여부는 제약을 확인)
        // --- 초기 상태 설정 ---

        for(int j = 0; j < k; j++){
            if(prereqMaks[j] == 0){
                long cost;
                if(j == 0){
                    cost = 0;
                } else {
                    if(dist[0][j] >= Integer.MAX_VALUE / 4) continue;
                    cost = dist[0][j]; 
                }
                dp[1<<j][j] = Math.min(dp[1<<j][j], cost);
            }
        }
        for(int mask = 0; mask <FULL; mask++){
            for(int last = 0; last < k; last++){
                if(dp[mask][last] >= INF_L) continue;
            }
        }
        

        // DP 전개
        for (int mask = 0; mask < FULL; mask++) {
            for (int last = 0; last < k; last++) {
                if (dp[mask][last] >= INF_L) continue;
                // 다음 후보
                for (int nxt = 0; nxt < k; nxt++) {
                    if ((mask & (1 << nxt)) != 0) continue; // 이미 활성화됨
                    // prereq가 모두 만족되었는가?
                    if ((prereqMask[nxt] & mask) != prereqMask[nxt]) continue;
                    // last -> nxt 비용
                    if (dist[last][nxt] >= Integer.MAX_VALUE / 4) continue; // 도달 불가
                    long nd = dp[mask][last] + dist[last][nxt];
                    int nm = mask | (1 << nxt);
                    if (nd < dp[nm][nxt]) dp[nm][nxt] = nd;
                }
            }
        }

        // 정답: 모든 패널이 활성화된 상태의 최소값
        int all = (1 << k) - 1;
        long ans = INF_L;
        for (int last = 0; last < k; last++) {
            ans = Math.min(ans, dp[all][last]);
        }
        if (ans >= INF_L) return -1; // 불가능 (문제 제약상 발생하지 않음)
        return (int) ans;
    }
}
