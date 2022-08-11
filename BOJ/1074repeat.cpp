#include <bits/stdc++.h>
using namespace std;

// N개의 바둑판에서 r행 c열이 몇번째로 순회하는지 조회하는 함수
int z(int n, int r, int c){
    // base condition
    int half = 1<<(n-1);
    if(n==0) return 0;
    // 이 단계해서 실행하는 문장
    if(r < half && c < half) return z(n-1,r,c);
    if(r < half && c >= half) return half*half + z(n-1,r,c-half);
    if(r >= half && c < half) return half*half*2 + z(n-1,r-half, c);
    if(r >= half && c >= half)  return half*half*3 + z(n-1,r-half, c-half);
}


int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int N,r,c;
    cin >> N >> r >> c;

    int a = z(N,r,c);
    cout << a;
}