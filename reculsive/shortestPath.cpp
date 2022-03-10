
// here에서 시작해서 남은 도시들을 방문할 수 있는 최단 경로의 길이를 반환한다.
// 나머지 도시들을 모두 방문하는 경로들 중 가장 짧은 것의 길이를 반환한다.
// 항상 0번 도시에서 시작한다고 가정한다.

double shortestPath2(int here, int visted){
    // 기저사례 모든 도시를 전부 방문했을 경우
    if(visted == (1<<n)-1) return dist[here][0];
    // 메모이제이션
    int& ret = cahce[here][visted];
    if(ret >= 0) return ret;
    ret = INF;   //이건  min 쓴다고 생각해라
    // 매우큰 값으로 초기화 하기
    for(int next = 0;next < n;++next){
        // 이미 방문한 도시인 경우
        if(visted & (1<<next)) continue;
        double cand = dist[here][next] + shortestPath2(next, visted + (1 << next));
        ret = min(cand,ret);
    }
    return ret;
}

// 비트마스크 기법은 16장

// 119.204





