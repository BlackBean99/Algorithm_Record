#include <bits/stdc++.h>
using namespace std;

int d[100];
int pre[100];
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    // 3으로 나눠지면 3으로 나눈다.
    // 2로 나눠지면 2로 나눈다
    // 아님1을 뺀다.
    int n;
    cin >> n;
    // 테이블 정의하기
    d[1] = 0;
    for(int i =2; i<=n; i++){
        d[i] = d[i-1] + 1;
        pre[i] = i-1;
        if(i%2==0 && d[i] > d[i/2] +1){
            d[i] = d[i/2] + 1;
            pre[i] = i/2;
        }
        if(i%3 == 0 && d[i] > d[i/3] + 1){
            d[i] = d[i/3] + 1;
            pre[i] = i/3;
        }
    }
    cout << d[n] << '\n';
    int cur = n;
    while(true){
        cout << cur<< ' ';
        if(cur == 1) break;
        cur = pre[cur];
    }

}