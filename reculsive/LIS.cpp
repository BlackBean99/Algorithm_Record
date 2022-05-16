

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

int n;
int cache[101],S[100],choices[101];
// S[start]에서 시작하는 증가부분수열 중 최대 길이를 반환한다.
int lis4(int start){
    // 메모이제이션
    int& ret = cache[start+1];
    if(ret != -1) return ret;
    // 항상 start는 있으니 최하 1로 초기화
    ret = 1;
    int bestNext = 1;
    for(int next = start+1;next<n;++next)
    if(start == -1 || S[start] < S[next]){
        int cand = lis4(next) + 1;
        if(cand > ret){
            ret = cand;
            bestNext = next;
        }
    }
    choices[start+1] = bestNext;
    return ret;
}

// choices에 저장된 것을 seq에 하나씩 밀어넣기.
void reconstruct(int start, vector<int>& seq){
    if(start != -1) seq.push_back(S[start]);
    int next = choices[start+1];
    if(next != -1) reconstruct(next, seq);
}