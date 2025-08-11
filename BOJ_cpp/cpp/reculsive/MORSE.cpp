
// 사전순서대로 완전탐색
void generator(int n, int m, string s){
    if(n==0 && m == 0){
        cout << s << endl;
        return;
    }
    if(n>0) generator(n-1,m, s + "-");
    if(m>0) generator(n,m-1, s + "-");
}

// skip개만큼 건너뛰기
int skip;
void generator2(int n, int m, string s){
    // 기저사례
    if(skip < 0) return;
    // 기저사례 n == m 인 경우
    if(skip == 0) return;
    if(n==0 && m == 0){
     cout << s << endl;
    --skip;
    return;
    }
    if(n > 0) generator2(n-1, m, s+ "-");
    if(m > 0) generator2(n,m-1,s + "o");
}

// 이항계수만큼 건너뛰기
const int M = 1000000000+100;
int bino[201][201];
// 필요한 이항계수를 계산해논다
int calcBino(){
    memset(bino,0,sizeof(bino));
    for(int i = 0; int <= 200 ; ++i){
        bino[i][0] = bino[i][i] = 1;
        for(int j=0;j<i;++j)
            bino[i][j] = min(M,bino[i-1][j-1] + bino[i-1][j]);
    }
}
// skip개수를 건너뛰고 출력한다.
void generator3(int n, int m, string s){
    if(skip < 0) return;
    if(n==0 && m ==0){
        if(skip == 0) cout << s << endl;
        --skip;
        return;
    }
    if(bino[n+m][n] <= skip){
        skip -= bino[n+m][n];
        return;
    }
    if(n>0) generator(n-1,m,s + "-");
    if(m>0) generator(n,m-1,s + "O");
}

// 더 깔끔하게 짜보자
// n개의 -,m개의 o로 구성된 신호중 skip개를 건너뛰고 만들어지는 신호를 반환한다.
string kth(int n, int m, string s){
    n=0인경우는 나머지 부분은 전부 o일수밖에 없다.
    if(n==0) return string(m,"o");
}