// r행 c열을 몇 번째로 방문했는지 출력한다
#include <bits/stdc++.h>
using namespace std;


//  2^N 2^N 의 크기에서 (r,c) 를 방문하는 순서를 반환하는 순서 
int z(int n, int r, int c){
    // base condition
    int half = 1<<(n-1);
    if(n==0) return 0;
    // 1번 케이스
    if(r < half & c < half) return z(n-1,r,c);
    // 2번 케이스
    if(r < half & c >= half) return half*half + z(n-1,r,c - half); 
    // 3번 케이스
    if(r >= half & c < half) return 2*half*half + z(n-1,r - half,c); 
    // 4번 케이스
    if(r >= half & c >= half) return 3*half*half + z(n-1,r-half,c-half); 

}


int main(void){
    //  N r c 입력
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, r, c;
    cin >> N >> r >> c;

    int ans = z(N,r,c);
    cout << ans;    
}