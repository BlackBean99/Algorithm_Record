#include <bits/stdc++.h>
#define X first
#define Y second

using namespace std;

int n,m;
vector<pair<int,int>> cctv;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int board[10][10];
int board2[10][10];

bool BOJ(int x, int y){
    return x<0||x>=n||y<0||y>=m;
}

void upd(int x, int y, int dir){
    while(1){
        x += dx[dir];
        y += dy[dir];
            //  범위를 벗어났거나, 벽을 만나면
        if(BOJ(x,y) || board2[x][y] ==6) return;
        if(board2[x][y] != 0) continue;
        board2[x][y] = 7;
    }
}
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >>n >>m;
    int mn = 0;
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){  
            cin >> board[i][j];
            if(board[i][j] != 0 && board[i][j] != 6){
                cctv.push_back({i,j});
            }
            if(board[i][j] == 0) mn++;
        }
    }

    // 순회
    // 순회변수
    for(int tmp = 0 ; tmp < (1<<(2*cctv.size()));tmp++){
        // 한번 순회하면 기존 배열값으로 초기화
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){     
                board2[i][j] = board[i][j];
            }
        }
        int brute = tmp;
        for(int i = 0; i <cctv.size();i++){
            int dir = brute %4;
            brute /= 4;
            int nx = cctv[i].X;
            int ny = cctv[i].Y;
            if(board[nx][ny] == 1){
                upd(nx,ny,dir);
            }
            if(board[nx][ny] == 2){
                upd(nx,ny,dir);
                upd(nx,ny,dir+2);
            }
            if(board[nx][ny] == 3){
                upd(nx,ny,dir);
                upd(nx,ny,dir+1);
            }
            if(board[nx][ny] == 4){
                upd(nx,ny,dir);
                upd(nx,ny,dir+1);
                upd(nx,ny,dir+2);
            }
            if(board[nx][ny] == 5){
                upd(nx,ny,dir);
                upd(nx,ny,dir+1);
                upd(nx,ny,dir+2);
                upd(nx,ny,dir+3);
            }
        }
        int val = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                val += (board2[i][j]==0);
            }
        }
        mn = min(mn,val);
    }
    cout << mn;
}