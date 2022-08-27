#include <bits/stdc++.h>

#define X first
#define Y second
using namespace std;

int board[1002][1002];
int dist[1002][1002];


int n, m;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> m >> n;
    queue<pair<int,int>> Q;

    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            cin >> board[i][j];
            if(board[i][j] == 1) Q.push({i,j});
            if(board[i][j] == 0) dist[i][j] = -1;
         }
    }
    while(!Q.empty()){
        auto cur = Q.front(); Q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx > n || ny < 0 || ny > m) continue;
            // 방문한 경우 넘어가자
            if(dist[nx][ny] >= 0) continue;
            dist[nx][ny] = dist[cur.X][cur.Y] + 1;
            Q.push({nx,ny});
        }
    }
    int ans = 0;

    for(int i = 0;i<n;i++){
        for(int j = 0;j<m;j++){
            if(dist[i][j] == -1){
                cout << -1;
                return 0;
            }
            ans = max(ans, dist[i][j]);
        }
    }
    cout << ans;
}