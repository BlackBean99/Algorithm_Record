#include <bits/stdc++.h>

using namespace std;


// 계단은 한계단 아님 두계단씩 오를 수 있다.
//  연속의 3계단을 모두 밟아서는 안된다.
// 마지막 도착 계단은 무조건 밟아야 한다.
int D[305][3];
int n;
int score[305];
int main(void){
    cin.tie(0);


    // ios::sync_with_stdio(false);
    // cin.tie(0);
    // for(int i = 0; i<=n; i++){
    //     if(n== 1){
    //         cout << s[1];
    //         return 0;
    //     }
    //     d[1][1] = s[1];
    //     d[1][2] = 0;
    //     d[2][1] = s[2];
    //     d[2][2] = s[1] + s[2];
    //     for(int = 3; i<=n; i++){
    //         d[i][1] = max(d[i-1][1], d[i-2][2] + s[i]);
    //         d[i][2] = d[i-1][1] + s[i];
    //     }
    //     cout << max(d[n][1],d[n][2]);
    // }
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n;
    score[0] = 0;
    for(int i =1; i<= n; i++){
        cin >> score[i];
    }
    D[1][1] = score[1];
    D[1][2] = 0;
    D[2][1] = score[1] + score[2];
    D[2][2] = score[2];

    for(int i =3; i<=n; i++){
        D[i][1] = D[i-1][2] + score[i];
        D[i][2] = max(D[i-2][2] + score[i], D[i-2][1] + score[i]);
    }
    cout << max(D[n][1],D[n][2]);
}