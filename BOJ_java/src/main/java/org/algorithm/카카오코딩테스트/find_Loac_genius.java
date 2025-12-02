import java.util.*;
import java.io.*;

// Solution class for the described problem
public class RoadCameraSolution {

    // combine x,y into a single long for HashMap key (avoid string)
    private static long pack(long x, long y) {
        return (x << 32) ^ (y & 0xffffffffL);
    }

    static class Road {
        long x1, y1, x2, y2;
        int limit; // camera limit at midpoint
        boolean horizontal;
        public Road(long x1,long y1,long x2,long y2,int limit){
            this.x1=x1; this.y1=y1; this.x2=x2; this.y2=y2; this.limit=limit;
            horizontal = (y1==y2);
        }
    }

    public static int[] solution(int[][] city, int[][] road) {
        int n = city.length;
        int m = road.length;

        Road[] roads = new Road[m];
        for(int i = 0; i < m; i++){
            roads[i] = new Road(road[i][0], road[i][1], road[i][2], road[i][3], road[i][4]);
        }
        // 2 Collect Special Point 
        /// Map coord -> nodeId, node attribute : camera limit(INF if node), and whether it's a city with which city index
        final int INF_LIMIT = Integer.MAX_VALUE;
        HashMap<Long, Integer> coord2id = new HashMap<>();
        ArrayList<Long> id2coord = new ArrayList<>();
        ArrayList<Integer> cameraLimit = newArrayList<>(); // per node, INT_LIMIT if no camera
        int nodeCount = 0;

        BiFunction<Long, Integer, Integer> addNode = (coord, cam) -> {
            Integer id = coord2id.get(coord);
            if(id == null) {
                id = nodeCount++;
                coord2id.put(coord, id);
                id2coord.add(coord);
                cameraLimit.add(cam == null ? INF_LIMIT : cam);
            } else {
                if(cam != null){
                    int cur = cameraLimit.get(id);
                    cameraList.set(id, Math.min(cur,cam));
                }
            }
            return id;
        }
        // 2a) add cityNode  // 도로 하나당 집이 여러개일수도 있잖아. (도로랑은 별개임) -> 어느 도로에 속해있는지도 정의해야하지.
        int[] cityNodeId = bew int[n];
        for(int i = 0; i<n; i++){
            long x = city[i][0], y = [i][1];
            long key = pack(x,y);
            Integer id = coord2id.get(key);
            if(id == null){
                id = nodeCount++;
                coord2id.put(key,id).
                id2coord.add(key);
                cameraLimit.add(INT_LIMIT);
                cityNodeId[i] = id;
            }
        }
        // 2b) camera add
        int[] roadMidNode = new int[m];
        for(int i = 0; i < m; i++){
            long x1 = roads[i].x1, y1 = roads[i].y1, x2 = roads[i].x2, y2 = roads[i].y2;
            long mx = (x1 + x2) / 2;
            long my = (y1 + y2) / 2;
            long key = pack(mx, my);
            Integer id = coord2id.get(key);
            if(id == null){
                id = nodeCount++;
                coord2id.put(key, id);
                id2coord.add(key);
                cameraLimit.add(roads[i].limit);
            }   
        }

                // 2b) add camera midpoints (and record their node camera limit)
        int[] roadMidNode = new int[m];
        for(int i=0;i<m;i++){
            long x1 = roads[i].x1, y1 = roads[i].y1, x2 = roads[i].x2, y2 = roads[i].y2;
            long mx = (x1 + x2) / 2; // length guaranteed even -> integer midpoint
            long my = (y1 + y2) / 2;
            long key = pack(mx,my);
            Integer id = coord2id.get(key);
            if(id == null){
                id = nodeCount++;
                coord2id.put(key,id);
                id2coord.add(key);
                cameraLimit.add(roads[i].limit);
            } else {
                // existing node -> multiple cameras possible -> take min
                cameraLimit.set(id, Math.min(cameraLimit.get(id), roads[i].limit));
            }
            roadMidNode[i] = id;
        }
        




        
    }
    public static int[] solution(int[][] city, int[][] road) {
        int n = city.length;
        int m = road.length;

        // 1) Build Road objects
        Road[] roads = new Road[m];
        for(int i=0;i<m;i++){
            roads[i] = new Road(road[i][0], road[i][1], road[i][2], road[i][3], road[i][4]);
        }

        // 2) Collect special points:
        // Map coord -> nodeId. Node attribute: camera limit (INF if none), and whether it's a city with which city index
        final int INF_LIMIT = Integer.MAX_VALUE;
        HashMap<Long,Integer> coord2id = new HashMap<>();
        ArrayList<Long> id2coord = new ArrayList<>();
        ArrayList<Integer> cameraLimit = new ArrayList<>(); // per node, INF_LIMIT if no camera
        int nodeCount = 0;

        // helper: add node if absent; update camera limit with min when multiple cameras on same point
        BiFunction<Long,Integer,Integer> addNode = (coord, cam) -> {
            Integer id = coord2id.get(coord);
            if(id == null){
                id = nodeCount++;
                coord2id.put(coord,id);
                id2coord.add(coord);
                cameraLimit.add(cam == null ? INF_LIMIT : cam);
            } else {
                if(cam != null){
                    int cur = cameraLimit.get(id);
                    cameraLimit.set(id, Math.min(cur, cam));
                }
            }
            return id;
        };

        // 2a) add city nodes
        int[] cityNodeId = new int[n];
        for(int i=0;i<n;i++){
            long x = city[i][0], y = city[i][1];
            long key = pack(x,y);
            Integer id = coord2id.get(key);
            if(id == null){
                id = nodeCount++;
                coord2id.put(key,id);
                id2coord.add(key);
                cameraLimit.add(INF_LIMIT);
            }
            cityNodeId[i] = id;
        }

        // 2b) add camera midpoints (and record their node camera limit)
        int[] roadMidNode = new int[m];
        for(int i=0;i<m;i++){
            long x1 = roads[i].x1, y1 = roads[i].y1, x2 = roads[i].x2, y2 = roads[i].y2;
            long mx = (x1 + x2) / 2; // length guaranteed even -> integer midpoint
            long my = (y1 + y2) / 2;
            long key = pack(mx,my);
            Integer id = coord2id.get(key);
            if(id == null){
                id = nodeCount++;
                coord2id.put(key,id);
                id2coord.add(key);
                cameraLimit.add(roads[i].limit);
            } else {
                // existing node -> multiple cameras possible -> take min
                cameraLimit.set(id, Math.min(cameraLimit.get(id), roads[i].limit));
            }
            roadMidNode[i] = id;
        }

        // 2c) find intersections between horizontal and vertical roads
        // we'll also need to add cities that lie on each road as special points but they're already nodes above
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j) continue;
                // check horizontal i with vertical j (or vice versa)
                if(roads[i].horizontal == roads[j].horizontal) continue;
                Road h = roads[i].horizontal ? roads[i] : roads[j];
                Road v = roads[i].horizontal ? roads[j] : roads[i];
                // horizontal h: y = hy, x in [hx1,hx2]
                long hy = h.y1;
                long hx1 = Math.min(h.x1,h.x2), hx2 = Math.max(h.x1,h.x2);
                long vx = v.x1;
                long vy1 = Math.min(v.y1,v.y2), vy2 = Math.max(v.y1,v.y2);
                if(vx >= hx1 && vx <= hx2 && hy >= vy1 && hy <= vy2){
                    long key = pack(vx, hy);
                    if(!coord2id.containsKey(key)){
                        int id = nodeCount++;
                        coord2id.put(key,id);
                        id2coord.add(key);
                        cameraLimit.add(INF_LIMIT); // intersection itself has no camera unless it's midpoints or equals camera (we already added midpoints earlier)
                    }
                }
            }
        }

        // (Cities might also lie on roads; they were already added)

        // 3) For each road, collect all special points that lie on that road, sort, and connect adjacent points
        ArrayList<IntArrayList> adj = new ArrayList<>(nodeCount);
        for(int i=0;i<nodeCount;i++) adj.add(new IntArrayList());

        for(int i=0;i<m;i++){
            Road r = roads[i];
            // collect all nodes whose coordinates lie on this road
            ArrayList<Long> pts = new ArrayList<>();
            long x1 = r.x1, y1 = r.y1, x2 = r.x2, y2 = r.y2;
            long minx = Math.min(x1,x2), maxx = Math.max(x1,x2);
            long miny = Math.min(y1,y2), maxy = Math.max(y1,y2);

            // scan through coord2id keys? That would be O(V*m) expensive.
            // Instead, we know candidates: cities, midpoints, intersections might lie on this road.
            // We'll check all nodes in coord2id but try to be practical. Since nodeCount can be large,
            // but we must do it: iterate id2coord.
            for(int id=0; id<nodeCount; id++){
                long key = id2coord.get(id);
                long px = key >> 32;
                long py = key & 0xffffffffL;
                // adjust for signed: convert back
                if(px > (1L<<31)-1) px -= (1L<<32);
                if(py > (1L<<31)-1) py -= (1L<<32);
                if(r.horizontal){
                    if(py == y1 && px >= minx && px <= maxx) pts.add(pack(px,py));
                } else {
                    if(px == x1 && py >= miny && py <= maxy) pts.add(pack(px,py));
                }
            }
            // remove duplicates and sort along axis
            Collections.sort(pts, (a,b) -> {
                long ax = a >> 32; long ay = a & 0xffffffffL;
                long bx = b >> 32; long by = b & 0xffffffffL;
                if(ax > (1L<<31)-1) ax -= (1L<<32);
                if(ay > (1L<<31)-1) ay -= (1L<<32);
                if(bx > (1L<<31)-1) bx -= (1L<<32);
                if(by > (1L<<31)-1) by -= (1L<<32);
                if(r.horizontal) {
                    // sort by x
                    return Long.compare(ax,bx);
                } else {
                    return Long.compare(ay,by);
                }
            });
            // connect consecutive distinct points
            Long prev = null;
            for(Long key : pts){
                if(prev == null){ prev = key; continue; }
                if(prev.equals(key)) continue;
                int u = coord2id.get(prev);
                int v = coord2id.get(key);
                adj.get(u).add(v);
                adj.get(v).add(u);
                prev = key;
            }
        }

        // 4) Prepare list of distinct camera limits for binary search
        TreeSet<Integer> limitSet = new TreeSet<>();
        for(int i=0;i<nodeCount;i++){
            int lim = cameraLimit.get(i);
            if(lim != INF_LIMIT) limitSet.add(lim);
        }
        Integer[] limits = limitSet.toArray(new Integer[0]);
        Arrays.sort(limits);

        // Helper BFS for reachability given threshold T:
        // nodes with cameraLimit < T are considered blocked (can't pass through)
        // nodes with cameraLimit >= T OR INF_LIMIT are allowed.
        class Reach {
            boolean canReach(int startId, int targetId, Integer threshold){
                boolean[] vis = new boolean[nodeCount];
                Deque<Integer> dq = new ArrayDeque<>();
                // if threshold == null => remove all camera nodes (for camera-free path test)
                // else allow nodes with cameraLimit >= threshold
                // But start node could be camera? Problem says cities don't coincide with camera
                dq.add(startId); vis[startId]=true;
                while(!dq.isEmpty()){
                    int u = dq.poll();
                    if(u == targetId) return true;
                    for(int idx=0; idx<adj.get(u).size(); idx++){
                        int v = adj.get(u).get(idx);
                        if(vis[v]) continue;
                        int lim = cameraLimit.get(v);
                        if(threshold == null){
                            // camera-free test: block any camera node (lim != INF)
                            if(lim != INF_LIMIT) continue;
                        } else {
                            if(lim != INF_LIMIT && lim < threshold) continue;
                        }
                        vis[v] = true;
                        dq.add(v);
                    }
                }
                return false;
            }
        }
        Reach reach = new Reach();

        int startNode = cityNodeId[0];

        // Precompute camera-free reachability (if true => result 0)
        boolean[] cameraFreeReachable = new boolean[n];
        // If camera-free graph allows reach from start to city i => result 0
        for(int i=1;i<n;i++){
            cameraFreeReachable[i] = reach.canReach(startNode, cityNodeId[i], null);
        }

        // Binary search for each city (we can do per city). Since number of distinct limits <= m and n<=100,
        // per-city binary search is fine.
        int[] answer = new int[n-1];
        for(int i=1;i<n;i++){
            if(cameraFreeReachable[i]) { answer[i-1] = 0; continue; }
            // else need max threshold T such that start->city reachable in graph where camera nodes with lim < T blocked
            int lo = 0, hi = limits.length-1, best = 0;
            while(lo <= hi){
                int mid = (lo+hi)/2;
                int T = limits[mid];
                if(reach.canReach(startNode, cityNodeId[i], T)){
                    best = T;
                    lo = mid+1;
                } else {
                    hi = mid-1;
                }
            }
            answer[i-1] = best; // if best==0 means no camera reachable path -> but cameraFreeReachable false ensures at least one camera exists on path; best might be 0 when limits empty
        }
        return answer;
    }

    // A tiny custom int-array list to reduce overhead (simple)
    static class IntArrayList extends ArrayList<Integer> {
        public IntArrayList(){ super(); }
    }

    // For running quick tests (not required in final)
    public static void main(String[] args){
        // Example 1
        int[][] city1 = {{-1,3},{7,3},{1,-1},{-2,6}};
        int[][] road1 = {
            {-7,7,7,7,80},
            {-3,3,9,3,45},
            {2,-4,-2,6,60},
            {1,-4,1,8,50},
            {5,1,5,7,70}
        };
        int[] res1 = solution(city1, road1);
        System.out.println(Arrays.toString(res1)); // expected [70,50,0]

        int[][] city2 = {{3,5},{3,3},{2,1},{9,1},{7,-1}};
        int[][] road2 = {
            {3,-2,3,4,30},
            {5,1,9,1,29},
            {3,4,3,8,99},
            {7,1,5,1,99},
            {7,-3,7,5,99}
        };
        int[] res2 = solution(city2, road2);
        System.out.println(Arrays.toString(res2)); // expected [0,30,29,29]
    }
}
