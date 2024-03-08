#include <bits/stdc++.h>
using namespace std;

#define MAX 1500002
using namespace std;

int n;
int t[MAX],p[MAX];
long long dp[MAX];


int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    //  입력 값
    for(int i = 1; i <= n;i++){
        int a, b;
        cin >> a >> b;
        t[i] = a;
        p[i] = b;
    }

    for(int i = n; i >= 1; i--){
        if(i + t[i] > n+1){
            dp[i] = dp[i+1];
        } else{
            dp[i] = max(dp[i+1], p[i] + dp[i+t[i]]);
        }
    }
    cout << dp[1];
}