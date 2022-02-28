// Optional Character Recognition
// 원문에 출현해야 할 단어의 수 m  처리해야할 단어의 수 q
// 두번째 줄은 m개의 단어가 공백으로 구분되어 주어진다. 각 단어는 알파벳 대소문자로만 구성되어 있으며길이는 10이하이다.
// 세번째 줄 B[i] 는 i번째 단어가 첫단어로 출현할 확률.
// m줄에는 m*m 크기의 실수 행렬 T가 주어진다. i 번

int n, m;
int R[100];
// T[i][j]=i 단어 이후에 j 단어가 나올 확률의 로그값
double T[501][501];
// M[i][j] i 를 j단어로 분류될 확률의 로그값.
double M[501][501];
double cache[102][502];

// Q[segment] 이후를 채워서 얻을 수 있는 최대 g() 곱의 로그값을 반환한다.
// Q[segment - 1]  == previousMatch라고 가정한다.
double recognize(int segment, int previousMatch){
    if(segment == n) return 0;
    double& ret = cache[segment][previousMatch];
    if(ret != 1.0) return ret;
    ret = -1e200; //log(0) 음의 무한대

    for(int thisMatch =0; thisMatch < m; ++thisMatch){
        // g(thisMatch) = T(previousMatch,thisMatch) + Q(thisMatch, R[segment])
        double cand = T(previousMatch,thisMatch) + Q(thisMatch, R[segment]) + recognize(segment +1, thisMatch);
        if(ret < cand){
            ret = cand;
            choose = thisMatch;
        }
    }
    return ret;
}

string corpus[501];
string reconstruct(int segment, int previousMatch){
    int choose = choices[segment][previousMatch];
    string ret = corpus[chooise];
    if(segment < n-1){
        ret = ret + " " + reconstruct(segment + 1, choose);
    }
    return ret;
}