#include <bits/stdc++.h>

using namespace std;

// N 개의 정수로 이루어진  수열의 두 수를 골랐을 때 그 차가  M 이상이면서
//  제일 작은 경우를 고르시오.
int n, m;
int a[100005];
int mn = 0x7fffffff;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for( int i = 0; i < n; i++) cin >> a[i];
    sort(a,a+n);
    int en = 0;
    for(int st = 0; st < n; st++){
        while(en < n && a[en] - a[st] < m) en++;
        if(en == n) break; // en 이 범위를 벗어날 경우
        mn = min(mn,a[en] - a[st]);
    }
    cout << mn;
}