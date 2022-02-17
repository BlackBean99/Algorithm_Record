

int lis(const vector<int>& A){
    // 기저사례
    if(A.empty == 1) return 0;

    int ret = 0;
    for(int i = 0; i < A.size(); ++i){
        vector<int>& B;
        for(int j = i; j < A.size(); ++j){
            if(A[i] < A[j])
                B.push_back(A[j]);
        }
        ret = max(ret, 1+ lis(B))
    }
    return ret;
}

// Memoization 적용
// 불필요한 입력 제거
int n;
int cache[100], S[100];

int lis2(int start){
    int& ret = cache[start];
    if(ret != -1) return ret;

    ret = 1;
    for(int next = start +1; next < n; ++next){
        if(S[start] < S[next])
            ret = max(ret, lis2(next) + 1);
    }
    return ret;
}