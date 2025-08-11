// n 은 도시의 수
int n;

// distance 거리를 저장하는 배열
double dist[MAX][MAX]; 

// path 지금까지 만든 경로
// visted  방문 여부
// current.length 지금 까지 만든 경로의 길이
// 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환
double shortestPath(vector<int>& path, vector<bool>& visted, double currentLength){
    // 기저사례 모든 도시를 다 방문했을 경우에 시작도시로 돌아간다.
    if(path.size() == n)
        return currentLength + dist[path[0]][path.back()];
    // Infinite  엄청 큰 값으로 초기화
    double ret = INF;
    for(int next = 0; next < n ; ++next){
        // 방문했으면 넘어감
        if(visted[next]) continue;
        // visted = 0이면
        int here = path.back();
        path.push_back(next);
        visted[next] = true;
        //  나머지 경로를 재귀 호출을 통해 완성하기, 가장짧은 경로의 길이를 얻는다.
        double cand = shortestPath(path,visted, currentLength + dist[here][next]);
        // 최적화
        ret = min(ret, cand);
        visted[next] = false;
        path.pop_back();
    }
        return ret;
}