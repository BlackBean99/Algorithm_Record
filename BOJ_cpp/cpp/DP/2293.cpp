#include <iostream>
using namespace std;


int main(void){
    // 최대 코인이 100 까지 이니까
    int coin[100];
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, k;
    cin >> n >> k;
    int dp[k+1];

    for (int i = 0; i < n; ++i)
        cin >> coin[i];

    for (int i = 3; i <= k; ++i) {
        dp[i] = 0;
    }
    dp[1] = 1;
//    dp[2] = 2;

    for (int j = 3; j <= k; ++j) {
        for (int i = 0; i < n; ++i) {
            if(j-coin[i] < 0) continue;
            dp[j] += dp[j - coin[i]];
        }
    }
    cout << dp[k];
}
