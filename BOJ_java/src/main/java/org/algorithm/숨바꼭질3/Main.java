package org.algorithm.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[100001]; // visited 배열 추가
    static int answer = Integer.MAX_VALUE;
    static int[] dx = new int[] {1, -1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        bfs(start, destination);
        System.out.println(answer);
    }

    private static void bfs(int start, int destination) {
        visited[start] = true;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            if (current.x == destination) {
                answer = Math.min(answer, current.cost); // 목표지점에 도달했을 때도 최소 시간을 업데이트해야 함
            }
            for (int dir = 0; dir < 3; dir++) {
                int nx;
                if (dir == 2) {
                    nx = current.x * 2;
                } else {
                    nx = current.x + dx[dir];
                }
                if (nx < 0 || nx > 100000 || visited[nx]) continue; // 범위를 벗어나거나 이미 방문한 노드인 경우 건너뜀
                visited[nx] = true;
                q.offer(new Node(nx, current.cost + (dir == 2 ? 0 : 1)));
            }
        }
    }
}

class Node {
    int x;
    int cost;

    public Node(int x, int cost) {
        this.x = x;
        this.cost = cost;
    }
}
