constd int INF = 987654321;
string N;

필요한함수
// 구분함수 ( 시작 인덱스, 끝 인덱스 )
int classify(int a, int b){
    
    // a,b에서  문자열 추출하기
        string M = N.substr(a,b-a+1);

    // 1번 난이도  숫자가 모두 같은경우
    if(M== string(M.size(),M[0])) return 1;

    // 등차수열 여부 확인
    bool progress = true;
    for(int i = 0 ; i < M.size(), ++i)
        if(M[i+1] = M[i] != M[1] - M[0])
            progress = false;

    // 2번 난이도  공차가 1인 단조 증가감소 수열인경우
    // abs 절댓값 함수
    if(progress && abs[M[1] - M[0]]==1)
        return 2;

    // 3번 난이도  두개의 숫자가 번갈아서 나올경우
    bool alternating = true;
    for(int i = 0 ; i < M.size(), ++i)
        if(M[i] != M[i%2])
            alternating = false;

    // 4번 난이도  숫자가 등차수열일경우
    if(alternating) return 4;

    // 5번 난이도  숫자가 모두 같은경우
    if(progress) return 5;
}
// 메모이제이션
int cache[10002];
// 구분을 실행시켜줄 슬라이싱함수
int memorize(int begin){
    // 수열의 끝이 달하면 종료
    if(begin == N.size()) return 0;
    int& ret = cache[begin];
    // 메모리에 없으면 넘어가
    if(ret != -1) return ret;
    ret = INF;
    for(int L =3; L<=5;++L)
        if(begin +L <= N.size()
            ret = min(ret,memorize(begin + L)+classify(begin, begin +L -1));
    return ret;
}