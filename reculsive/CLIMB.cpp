int cache[MAX_N][2*MAX_N + 1];
int n, m;


// 달팽이가 days동안 climbed만큼 기어올라왔을때,
// m 일 전까지 n미터를 기어 올라올 수 있는 경우의 수
int climb(int days, int climbed){
    // 기저사례 도착한 경우
    if(days==m) return climbed >= n ? 1: 0;
    // 메모이제이션
    int& ret = cache[days][climbed];
    if(ret != -1) return ret;

    return ret = climbed(days+1, climbed+1) + climbed(days+1,climbed+2); 

}

// 확률이 다른경우
int climb2(int days, int climbed){
    // 기저사례 도착한 경우
    if(days==m) return climbed >= n ? 1: 0;
    // 메모이제이션
    int& ret = cache[days][climbed];
    if(ret != -1) return ret;

    return ret = 0.75*climbed(days+1, climbed+1) + 0.25*climbed(days+1,climbed+2); 

}