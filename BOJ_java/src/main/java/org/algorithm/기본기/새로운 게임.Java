import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] color;                 // 0: 흰, 1: 빨, 2: 파
    static List<Integer>[][] stacks;      // 각 칸의 말 스택(아래 -> 위)
    static int[] pr, pc, pd;              // 각 말의 위치(r, c)와 방향(d)
    // 방향: 0:→, 1:←, 2:↑, 3:↓  (입력 1~4는 각각 →,←,↑,↓라서 d-1로 변환)
    static final int[] dr = {0, 0, -1, 1};
    static final int[] dc = {1, -1, 0, 0};
    static final int[] rev = {1, 0, 3, 2}; // 반대 방향 매핑

    static boolean inBounds(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        color = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pr = new int[K];
        pc = new int[K];
        pd = new int[K];

        stacks = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stacks[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1; // 1~4 -> 0~3
            pr[i] = r; pc[i] = c; pd[i] = d;
            stacks[r][c].add(i); // 초기에는 한 칸에 여러 말 없음(문제 보장)
        }

        int ans = simulate();
        System.out.println(ans);
    }

    static int simulate() {
        for (int turn = 1; turn <= 1000; turn++) {
            for (int i = 0; i < K; i++) {
                int r = pr[i], c = pc[i], d = pd[i];
                int nr = r + dr[d], nc = c + dc[d];

                // 파란색 또는 범위 밖이면: 방향 반전하고 한 칸 재시도
                if (!inBounds(nr, nc) || color[nr][nc] == 2) {
                    d = rev[d];
                    pd[i] = d; // 방향은 반전 상태로 유지
                    nr = r + dr[d];
                    nc = c + dc[d];
                    // 재시도도 파란색/밖이면 이동하지 않음
                    if (!inBounds(nr, nc) || color[nr][nc] == 2) {
                        continue;
                    }
                }

                // 현재 칸의 스택에서 i와 그 위의 묶음을 떼어낸다
                List<Integer> cur = stacks[r][c];
                int idx = cur.indexOf(i);
                List<Integer> moving = new ArrayList<>(cur.subList(idx, cur.size()));
                cur.subList(idx, cur.size()).clear();

                // 색 처리
                if (color[nr][nc] == 1) {
                    Collections.reverse(moving); // 빨간색: 묶음 순서 뒤집기
                }
                // 흰색(0)은 그대로, 파란색(2)은 위에서 이미 처리됨

                // 목적지에 올리기
                List<Integer> dest = stacks[nr][nc];
                dest.addAll(moving);

                // 좌표 갱신
                for (int m : moving) {
                    pr[m] = nr;
                    pc[m] = nc;
                }

                // 종료 조건 체크
                if (dest.size() >= 4) {
                    return turn;
                }
            }
        }
        return -1; // 1000턴 내 종료 안 되면 -1
    }
}