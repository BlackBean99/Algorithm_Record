// k 번째 LIS 구하기  : LIS개수 세기
const int MAX = 2000000000 + 1;
int n;
int cacheLen[501]. cacheCnt[501], S[500];

// S[start]에서 시작하는 증가 부분 수열 중 최대 길이를 반환한다.
int lis(int start){
    // 기저사례
    // 메모이제이션
    int& ret = cacheLen[start + 1];
    if(ret != -1) return ret;
    // 항상 S[start] 는 있기 떄문에 길이는 최하 1
    ret = 1;

    for(int next = start +1; next < n; ++next){
        if(start == -1 || S[start] < S[next])
            ret = max(ret, lis(next) + 1);
    }
    return ret;
}

int lis(int start){
    int& ret = cacheLen[start + 1];
    if(ret != -1) return ret;

    ret = 1;
    for( int next =0; next< n;++next){
        if(start == -1 || S[start] < S[next])
            ret = max(ret,lis(next) + 1);
        return ret;
    }
}

int count(int start){
    // 기저사례 LIS의 길이가 1인경우
    if(lis(start) == 1) return 1;
    // 메모이제이션
    int& ret = cacheCnt[start + 1];
    if(ret != -1) return ret;
    ret = 0
    
    for(int next = start; next < n ; ++next){
        if((start  == -1 || S[start] < S[next]
            && lis(start) == lis(next) + 1))
            ret = min<long long>(MAX,(long long)ret + count(next));
    }
    return ret;
}


