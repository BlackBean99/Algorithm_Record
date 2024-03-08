#include <bits/stdc++.h>

using namespace std;

int n,s;

int board[102];
int visited[102];

int cnt;

void func(int cur,int tot){
    if(cur == n){
        if(tot == s) cnt++;
        return;
    }
    // 0을 채워넣는다.
    func(cur+1,tot);
    // 0이 아닌 현재 인덱스의 값을 채워 넣는다.
    func(cur+1, tot + board[cur]);
}

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    cin >> n >> s;

    for(int i = 0 ; i < n; i++){
        cin >> board[i];
    }
    func(0,0);
    if(s==0) cnt--;
    cout << cnt;
}