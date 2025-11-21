import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[][] plus;
    static int[][] food;
    static ArrayList<Integer>[][] trees;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        plus = new int[n][n];
        food = new int[n][n];
        trees = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
                food[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        // 초기 입력은 정렬되지 않을 가능성 있으므로 정렬
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Collections.sort(trees[i][j]);
            }
        }

        while (k-- > 0) {

            // ------------------ 봄 + 여름 ------------------
            int[][] dead = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (trees[i][j].isEmpty()) continue;

                    ArrayList<Integer> newList = new ArrayList<>();
                    int size = trees[i][j].size();

                    for (int idx = 0; idx < size; idx++) {
                        int age = trees[i][j].get(idx);
                        if (food[i][j] >= age) {
                            food[i][j] -= age;
                            newList.add(age + 1);
                        } else {
                            dead[i][j] += age / 2;
                        }
                    }
                    trees[i][j] = newList;
                }
            }

            // 여름
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    food[i][j] += dead[i][j];
                }
            }

            // ------------------ 가을 ------------------
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int age : trees[i][j]) {
                        if (age % 5 == 0) {
                            for (int d = 0; d < 8; d++) {
                                int nx = i + dx[d];
                                int ny = j + dy[d];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                    trees[nx][ny].add(0, 1); // 앞에 삽입 → 정렬 유지됨
                                }
                            }
                        }
                    }
                }
            }

            // ------------------ 겨울 ------------------
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    food[i][j] += plus[i][j];
        }

        // ------------------ 나무 개수 세기 ------------------
        int answer = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                answer += trees[i][j].size();

        System.out.println(answer);
    }
}
