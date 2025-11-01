import java.util.*;

public class FindLoad {
    static class Edge { int to; Edge(int to){ this.to = to; } }

    public static void main(String[] args) {
        int[][][] cities = {
            {{-1,3},{7,3},{1,-1},{-2,6}},
            {{3,5},{3,3},{2,1},{9,1},{7,-1}}
        };

        int[][][] loads = {
            {{-7,7,7,7,80},{-3,3,9,3,45},{2,-4,-2,6,60},{1,-4,1,8,50},{5,1,5,7,70}},
            {{3,-2,3,4,30},{5,1,9,1,29},{3,4,3,8,99},{7,1,5,1,99},{7,-3,7,5,99}}
        };

        int[][] results = {
            {70,50,0},
            {0,30,29,29}
        };

        for (int t = 0; t < cities.length; t++) {
            int[] out = solution(cities[t], loads[t]);
            System.out.println("Expected: " + Arrays.toString(results[t]));
            System.out.println("Result:   " + Arrays.toString(out));
            System.out.println();
        }
    }

    private static int[] solution(int[][] city, int[][] road) {
        // 1) 모든 점(도시, 카메라, 교차점)을 수집
        // keyToId: "x,y" -> id
        Map<String,Integer> keyToId = new HashMap<>();
        List<long[]> pts = new ArrayList<>(); // index -> {x,y}
        // 도시들 먼저 등록 (도시의 id를 기억)
        int nCity = city.length;
        int[] cityNodeId = new int[nCity];
        for (int i = 0; i < nCity; i++) {
            String k = city[i][0] + "," + city[i][1];
            int id = addPoint(k, city[i][0], city[i][1], keyToId, pts);
            cityNodeId[i] = id;
        }

        // 각 도로의 카메라(정중앙) 추가 & 저장
        int m = road.length;
        long[][] camPos = new long[m][2];
        int[] camNodeId = new int[m];
        int[] camLimit = new int[m];
        for (int i = 0; i < m; i++) {
            int x1 = road[i][0], y1 = road[i][1], x2 = road[i][2], y2 = road[i][3], lim = road[i][4];
            long cx = (long)(x1 + x2) / 2L;
            long cy = (long)(y1 + y2) / 2L;
            camPos[i][0] = cx; camPos[i][1] = cy; camLimit[i] = lim;
            String k = cx + "," + cy;
            camNodeId[i] = addPoint(k, (int)cx, (int)cy, keyToId, pts);
        }

        // 2) 도로들 사이의 교차점 계산 (각 도로 쌍)
        // 교차가 단일 점인 경우만 추가(문제 조건 상 최대 한 점)
        for (int i = 0; i < m; i++) {
            long x1 = road[i][0], y1 = road[i][1], x2 = road[i][2], y2 = road[i][3];
            long xmin1 = Math.min(x1,x2), xmax1 = Math.max(x1,x2);
            long ymin1 = Math.min(y1,y2), ymax1 = Math.max(y1,y2);
            for (int j = i+1; j < m; j++) {
                long x3 = road[j][0], y3 = road[j][1], x4 = road[j][2], y4 = road[j][3];
                long xmin2 = Math.min(x3,x4), xmax2 = Math.max(x3,x4);
                long ymin2 = Math.min(y3,y4), ymax2 = Math.max(y3,y4);

                long xiLow = Math.max(xmin1, xmin2);
                long xiHigh = Math.min(xmax1, xmax2);
                long yiLow = Math.max(ymin1, ymin2);
                long yiHigh = Math.min(ymax1, ymax2);

                // 교차 영역이 단일 점인지 확인
                if (xiLow <= xiHigh && yiLow <= yiHigh) {
                    if (xiLow == xiHigh && yiLow == yiHigh) {
                        String k = xiLow + "," + yiLow;
                        addPoint(k, (int)xiLow, (int)yiLow, keyToId, pts);
                    } else {
                        // 범위가 면적(길게 겹치는 경우)은 문제 조건(최대 한 점)에서 제외되므로 무시하거나
                        // (이 경우 입력 제약 위반), 그냥 넘어갑니다.
                    }
                }
            }
        }

        // 3) 각 도로 위에 포함되는 포인트들을 모아서 정렬하고 인접 연결
        int totalNodes = pts.size();
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            long x1 = road[i][0], y1 = road[i][1], x2 = road[i][2], y2 = road[i][3];
            long xmin = Math.min(x1,x2), xmax = Math.max(x1,x2);
            long ymin = Math.min(y1,y2), ymax = Math.max(y1,y2);

            List<long[]> ptsOn = new ArrayList<>(); // {coord, nodeId} coord는 정렬키(단일 좌표)
            boolean horizontal = (y1 == y2);

            for (int id = 0; id < totalNodes; id++) {
                long px = pts.get(id)[0], py = pts.get(id)[1];
                if (px >= xmin && px <= xmax && py >= ymin && py <= ymax) {
                    // 해당 점이 선분 위에 있는지 확인 (선분이 축에 평행하므로 간단)
                    if (horizontal && py == y1) {
                        ptsOn.add(new long[]{px, id});
                    } else if (!horizontal && px == x1) {
                        ptsOn.add(new long[]{py, id}); // 세로인 경우 y로 정렬
                    }
                }
            }

            ptsOn.sort(Comparator.comparingLong(a -> a[0]));
            for (int k = 0; k + 1 < ptsOn.size(); k++) {
                int aId = (int) ptsOn.get(k)[1];
                int bId = (int) ptsOn.get(k+1)[1];
                graph.get(aId).add(new Edge(bId));
                graph.get(bId).add(new Edge(aId));
            }
        }

        // 4) 카메라 노드의 limit을 nodeId -> limit map으로 변환
        Map<Integer,Integer> nodeCameraLimit = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int nid = camNodeId[i];
            int lim = camLimit[i];
            if (nodeCameraLimit.containsKey(nid)) {
                nodeCameraLimit.put(nid, Math.min(nodeCameraLimit.get(nid), lim));
            } else {
                nodeCameraLimit.put(nid, lim);
            }
        }

        // 5) 도시별 결과 계산
        int[] answer = new int[nCity-1];
        // (A) 카메라를 전혀 지나지 않는 경로가 있는지 확인 -> BFS on graph excluding camera nodes
        boolean[] isCameraNode = new boolean[totalNodes];
        for (int nid : nodeCameraLimit.keySet()) isCameraNode[nid] = true;

        boolean[] reachableWithoutCamera = bfsNoCamera(graph, isCameraNode, cityNodeId[0]);

        // (B) 최대-보틀넥 경로 (카메라 포함 경로의 최대 최소값)
        int INF = Integer.MAX_VALUE / 4;
        int[] best = new int[totalNodes];
        Arrays.fill(best, -1);
        // priority queue: larger bottleneck 먼저 (max-heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        best[cityNodeId[0]] = INF;
        pq.add(new int[]{cityNodeId[0], INF});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int bw = cur[1];
            if (bw < best[now]) continue;
            for (Edge e : graph.get(now)) {
                int to = e.to;
                int nb = bw;
                if (nodeCameraLimit.containsKey(to)) {
                    nb = Math.min(nb, nodeCameraLimit.get(to));
                }
                if (nb > best[to]) {
                    best[to] = nb;
                    pq.add(new int[]{to, nb});
                }
            }
        }

        for (int i = 1; i < nCity; i++) {
            int tid = cityNodeId[i];
            if (reachableWithoutCamera[tid]) {
                answer[i-1] = 0;
            } else {
                int val = best[tid];
                if (val <= 0) answer[i-1] = 0;
                else if (val >= INF/2) {
                    // theoretically INF means no camera encountered, but that case should have been caught above.
                    answer[i-1] = 0;
                } else answer[i-1] = val;
            }
        }

        return answer;
    }

    private static boolean[] bfsNoCamera(List<List<Edge>> graph, boolean[] isCamera, int start) {
        int n = graph.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        if (isCamera[start]) return vis; // 출발이 카메라인 경우(문제상 출발 도시는 카메라 위치 아님)
        vis[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : graph.get(u)) {
                int v = e.to;
                if (isCamera[v]) continue; // 카메라 노드 통과 금지 (no-camera 경로만)
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return vis;
    }

    private static int addPoint(String key, int x, int y, Map<String,Integer> map, List<long[]> pts) {
        if (map.containsKey(key)) return map.get(key);
        int id = pts.size();
        map.put(key, id);
        pts.add(new long[]{x,y});
        return id;
    }
}
