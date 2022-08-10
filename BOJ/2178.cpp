#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second // pair에서 first, second를 줄여서 쓰기 위해서 사용

string board[102];
int dist[102][102];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int n,m;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n >> m;
    for(int i = 0; i < n; i++)
        cin >> board[i];
    // 거리 초기화
    for(int i = 0; i < n; i++) fill(dist[i],dist[i]+m,-1);
    queue<pair<int,int> > Q;
    Q.push({0,0});
    dist[0][0] = 0;
    while(!Q.empty()){
        pair<int,int> cur = Q.front();
        Q.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            // 1인 아닌 경우 pass
            // 경로를 이탈한 경우
            // if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // if(board[nx][ny] != 1) continue;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(dist[nx][ny] >= 0 || board[nx][ny] != '1') continue;
            // 1이 아닌 경우, 가려는 곳이 0보다 크면 이전에 간것이기 때문에 생략
            dist[nx][ny] = dist[cur.X][cur.Y]+1;
            Q.push({nx,ny});
        }
    }
    cout << dist[n-1][m-1]+1;
}