#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second
char board[102][102];
int Fdist[102][102];
int Mdist[102][102];


int main(void){
    int n,m;
    int dx[4] = {1,0,-1,0};
    int dy[4] = {0,1,0,-1};

    ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> m;
  queue<pair<int,int> > ManQ;
  queue<pair<int,int> > FireQ;

  for(int i = 0; i < n; i++){
    fill(Mdist[i], Mdist[i]+m, -1);
    fill(Fdist[i], Fdist[i]+m, -1);    
  }
  
  for(int i = 0; i < n; i++)
    cin >> board[i];


  for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
        if(board[i][j] == 'J'){
            ManQ.push({i,j});
            Mdist[i][j] = 0;
        }
        if(board[i][j] == 'F'){
            FireQ.push({i,j});
            Fdist[i][j] = 0;
        }
    }
  }

    // 불의 distance를 계산
    while(!FireQ.empty()){
        pair<int,int> cur = FireQ.front(); FireQ.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(Fdist[nx][ny] >= 0 || board[nx][ny] == '#') continue;
            Fdist[nx][ny] = Fdist[cur.X][cur.Y] + 1;
            FireQ.push({nx,ny});
        }
    }
    
    // 불의 distance를 계산
    while(!ManQ.empty()){
        pair<int,int> cur = ManQ.front(); ManQ.pop();
        for(int dir = 0; dir < 4; dir++){
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            int distance = Mdist[cur.X][cur.Y] + 1;;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                cout << distance;
                return 0;
            }
            if(board[nx][ny] == '#') continue; 
            if(Fdist[nx][ny] != -1 && Fdist[nx][ny] <= distance) continue;
            Mdist[nx][ny] = distance;
            ManQ.push({nx,ny});
        }
    }
    cout << "IMPOSSIBLE";
}