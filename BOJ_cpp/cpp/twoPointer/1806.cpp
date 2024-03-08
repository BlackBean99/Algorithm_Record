#include <bits/stdc++.h>

using namespace std;
//  주어진 수열중에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것중
// 가장 짧은 것의 길이를 구하라
int N, S;
int a[100005];

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> S;
    for(int i =0;i<N;i++) cin >> a[i];

    int en = 0;
    // 부분합의 길이
    int minLen = 0x7fffffff;
    // 부분합의 크기
    int tot = a[0];
    for(int st = 0 ; st < N; st++){
        while(en < N && tot < S){
            en++;
            if(en != N) tot += a[en];
        }
        if(en == N) break;
        minLen = min(minLen,en-st+1);
        tot -= a[st];
    }
    if(minLen == 0x7fffffff) minLen = 0;
    cout << minLen;
}