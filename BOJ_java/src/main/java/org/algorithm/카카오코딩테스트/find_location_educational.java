import java.io.*;
import java.util.*;

/** 좌표 포인트 (long 사용: |coord| ≤ 1e9) */
class Pt {
    final long x, y;
    Pt(long x, long y) { this.x = x; this.y = y; }
    @Override public boolean equals(Object o){
        if (!(o instanceof Pt)) return false;
        Pt p = (Pt)o; return x==p.x && y==p.y;
    }
    @Override public int hashCode(){ return Objects.hash(x, y); }
}

/** 도로: 축 평행 선분 + 중점 카메라 limit */
class Road {
    final long x1,y1,x2,y2; 
    final int limit;
    final boolean horiz;
    final Pt mid;
    Road(long x1,long y1,long x2,long y2,int limit){
        this.x1=x1; this.y1=y1; this.x2=x2; this.y2=y2; this.limit=limit;
        this.horiz = (y1==y2);
        if (horiz) {
            long mx = (x1 + x2) / 2;
            this.mid = new Pt(mx, y1);
        } else {
            long my = (y1 + y2) / 2;
            this.mid = new Pt(x1, my);
        }
    }
    boolean contains(Pt p){
        if (horiz) return p.y==y1 && p.x>=x1 && p.x<=x2;
        else       return p.x==x1 && p.y>=y1 && p.y<=y2;
    }
}

// 도로는 카메라를 가지고 있을수도 있고 아닐수도 있다.
// 세로선 or not
// 카메라는 mid 점에 위치해힜다.
class Road {
    final long x1,x2,y1,y2;
    final int limit;
    final boolean horizontal;
    final Pt mid;
        Road(long x1,long y1,long x2,long y2,int limit){
        this.x1=x1; this.y1=y1; this.x2=x2; this.y2=y2; this.limit=limit;
        this.horiz = (y1==y2);
        if (horiz) {
            long mx = (x1 + x2) / 2;
            this.mid = new Pt(mx, y1);
        } else {
            long my = (y1 + y2) / 2;
            this.mid = new Pt(x1, my);
        }
    }
    // x1 < x2, y1 < y2를 전제로 작성한다.
    boolean contains(Pt p){
        return horizontal ? p.y==y1 && p.x >= x1 && p.x <= x2 : p.x==x1 && p.y >= y1 && p.y <= y2;
    }
}

class Node implements Comparable<Node> {
    int v; long bottleNeck;
    Node(int v, long b) { this.v=v;this.b=b;}
    public int compareTo(Node o) { return Long.compare(o.bottleneck, this.bottleneck);}
}
public class Solution {
    static final long INF = Long.MAX_VALUE/4;
    public int[] solution(int[][] city, int[][] road){
        // initiation of data
        int n = city.length;
        int m = road.length
        Pt[] cities = new Pt[n];

        // 1) 포인트, 도로, 카메라 집계
        for(int i = 0 ; i < n; i++){
            cities[i] = new Pt(city[i][0], city[i][1]);
        }
    }
}


/** 우선순위 큐용 노드 (widest path) */
class Node implements Comparable<Node>{
    int v; long bottleneck;
    Node(int v,long b){ this.v=v; this.bottleneck=b; }
    public int compareTo(Node o){ return Long.compare(o.bottleneck, this.bottleneck); }
}

public class Solution {
    static final long INF = Long.MAX_VALUE/4;

    // 입력: cities[n][2], roads[m][5]
    public int[] solution(int[][] city, int[][] road){
        int n = city.length;
        int m = road.length;

        // 1) 포인트, 도로, 카메라 용량 집계
        Pt[] cities = new Pt[n];
        for (int i=0;i<n;i++) cities[i] = new Pt(city[i][0], city[i][1]);

        Road[] roads = new Road[m];
        for (int i=0;i<m;i++){
            long x1=road[i][0], y1=road[i][1], x2=road[i][2], y2=road[i][3];
            int limit = road[i][4];
            // 입력 보정: x1<=x2, y1<=y2가 보장됨
            roads[i] = new Road(x1,y1,x2,y2,limit);
        }

        // 카메라 좌표 → 최솟값
        Map<Pt,Integer> camCap = new HashMap<>();
        for (Road r: roads){
            camCap.merge(r.mid, r.limit, Math::min);
        }

        // 2) 모든 노드 후보 수집: 도시, 각 도로의 끝점/중점, 도로 교차점
        Set<Pt> nodeSet = new HashSet<>();
        Collections.addAll(nodeSet, cities);
        for (Road r: roads){
            nodeSet.add(new Pt(r.x1, r.y1));
            nodeSet.add(new Pt(r.x2, r.y2));
            nodeSet.add(r.mid);
        }
        // 교차점(수평-수직만 교차 가능) // 도로와 도로의 관계
        for (int i=0;i<m;i++){
            for (int j=i+1;j<m;j++){
                Road a=roads[i], b=roads[j];
                if (a.horiz==b.horiz) continue; // 겹침 금지 조건
                Road h=a.horiz?a:b, v=a.horiz?b:a;
                long ix=v.x1, iy=h.y1;
                if (ix>=h.x1 && ix<=h.x2 && iy>=v.y1 && iy<=v.y2){
                    nodeSet.add(new Pt(ix, iy));
                }
            }
        }

        // 도로 위 도시에 대한 추가 점은 이미 nodeSet에 포함(contains 체크는 연결 시에 사용)

        // 3) 포인트 id 매핑
        List<Pt> nodes = new ArrayList<>(nodeSet);
        Map<Pt,Integer> id = new HashMap<>();
        for (int i=0;i<nodes.size();i++) id.put(nodes.get(i), i);

        // 의문점 1 왜 id를 편성했을까?

        // 4) 그래프 구성: 도로별로 그 위의 포인트들을 정렬 후 인접 연결
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            g.add(new ArrayList<>());
        }
        for(Road r: roads) {
            List<Pt> on = new ArrayList<>();
            for(Pt p: nodes) if(r.contains(p)) on.add(p);
            if(r.horizontal) on.sort(Comparator.comparingLong(p -> p.x));
            else on.sort(Comparator.comparingLong(p -> p.y));
            for(int i=0;i+1 < on.size(); i++){
                int u = id.get(on.get(i)), v=id.get(on.get(i+1));
                g.get(u).add(v); g.get(v).add(u);
            }
        }
        // 5. 도시 id 
        // 6. 도로 양측 포인트
        // 6. 도로 가운데
        // 7. 네비게이션
        // 8. intercect


        



        List<List<Integer>> g = new ArrayList<>();
        for (int i=0;i<nodes.size();i++) g.add(new ArrayList<>());

        for (Road r: roads){
            // 이 도로 위의 포인트만 추출
            List<Pt> on = new ArrayList<>();
            for (Pt p: nodes) if (r.contains(p)) on.add(p);
            // 정렬
            if (r.horiz) on.sort(Comparator.comparingLong(p->p.x));
            else         on.sort(Comparator.comparingLong(p->p.y));
            // 인접 연결(무향)
            for (int i=0;i+1<on.size();i++){
                int u = id.get(on.get(i)), v = id.get(on.get(i+1));
                g.get(u).add(v); g.get(v).add(u);
            }
        }

        // 5) 도시 id 매핑
        int[] cityId = new int[n];
        for (int i=0;i<n;i++) cityId[i] = id.get(cities[i]);

        // 6) 노드 용량(cap) 준비
        // cap[id] = limit or MAX_VALUE
        long[] cap = new long[nodes.size()];
        Arrays.fill(cap, INF);
        for (Map.Entry<Pt,Integer> e: camCap.entrySet()){
            int idx = id.get(e.getKey());
            cap[idx] = e.getValue(); // 카메라가 있는 지점만 유한 값
        }

    
        // 7) 0-경로(BFS: 카메라 없는 노드만 통과) & 8) widest path (PQ)
        int src = cityId[0];
        boolean[] cameraFreeReach = cameraFreeReachable(g, cap, src);

        long[] best = widestPathByNodeCap(g, cap, src);

        int[] ans = new int[n-1];
        for (int i=2;i<=n;i++){
            int dst = cityId[i-1];
            if (cameraFreeReach[dst]) ans[i-2] = 0;
            else {
                long b = best[dst];
                ans[i-2] = (b>=INF/2? 0 : (int)b); // 이 케이스는 거의 안 나오지만 가드
            }
        }
        return ans;
    }

    /** 카메라 없는 노드만 지나서 도달 가능한지 */
    static boolean[] cameraFreeReachable(List<List<Integer>> g, long[] cap, int src){
        int N = g.size();
        boolean[] vis = new boolean[N];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(src); vis[src]=true;
        while(!dq.isEmpty()){
            int u = dq.poll();
            for(int v: g.get(u)){
                if (vis[v]) continue;
                if (cap[v] < Long.MAX_VALUE/2) continue; // 카메라 노드면 통과 금지
                vis[v]=true; dq.add(v);
            }
        }
        return vis;
    }

    

    /** 노드 용량(카메라 제한)을 병목으로 하는 widest path */
    static long[] widestPathByNodeCap(List<List<Integer>> g, long[] cap, int src){
        int N = g.size();
        long[] best = new long[N];
        Arrays.fill(best, -1);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        best[src] = Long.MAX_VALUE/4;
        pq.add(new Node(src, best[src]));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.bottleneck != best[cur.v]) continue;
            for (int v: g.get(cur.v)){
                long cand = Math.min(cur.bottleneck, cap[v]); // v를 통과해야 하므로 v의 용량이 병목 후보
                if (cand > best[v]){
                    best[v]=cand;
                    pq.add(new Node(v, cand));
                }
            }
        }
        return best;
    }
}
