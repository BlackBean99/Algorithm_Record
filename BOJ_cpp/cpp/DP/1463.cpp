#include <bits/stdc++.h>

using namespace std;
int n;
int D[1000005];
int main(void){
    cin.tie(0);
    ios::sync_with_stdio(false);
    cin >> n;

    // n /3,  n/2 , n-1 3가지 연산중 하나를 선택하여 최소 연산 수
    D[1] = 0;
    for(int i =2; i<=n;i++){
        D[i] = D[i-1]+1;
        if(i % 2 == 0) D[i] = min(D[i],D[i/2]+1);
        if(i % 3 == 0) D[i] = min(D[i],D[i/3] +1);
    }
    cout << D[n];
}