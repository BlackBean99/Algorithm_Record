int n, d, p, q;
// connected[i][j]  마을 i,j가 연결되어 있나 여부
// deg[i] 마을 i와 연결된 마을의 개수

int connected[51][51], deg[51];
double search(vector<int>& path){
    // 기저사례 d일 경우 
    if(path.size() == d+1){
        if(path.back != q) return 0.0;
        double ret = 1.0;
        for(int i=0; i+1 < path.size(); ++i){
            ret /= deg[path[i]];
            return ret;
        }
    }
    double ret = 0;
    // 경로의 다음 위치를 결정한다.
    for(int there = 0; there < n; ++there){
        if(connected[path.back()][there])
            path.push_back(there);
            ret += search(path);
            path.pop_back();
    }
    return ret;
}
// 입력값 줄이기
int search2(int here, int days){
    // 기저사례 d일이 지난경우
    if(days == d) return (here ==q ? 1.0 : 0.0);
    // 메모이제이션
    double& ret = cache[here][days];
    if(ret > -0.5) return ret;
    ret = 0.0;
    for(int there = 0; there < n; ++there)
        if(connected[here][days])
            ret += search2(there, days) / deg[here]
    return ret;
}

// \durtnsdmfh 
int search3(int here, int days){
    // 기저사례 d일이 지난경우
    if(days == d) return (here ==q ? 1.0 : 0.0);
    // 메모이제이션
    double& ret = cache[here][days];
    if(ret > -0.5) return ret;
    ret = 0.0;
    for(int there = 0; there < n; ++there)
        if(connected[here][days])
            ret += search3(there, days-1) / deg[there]
    return ret;
}