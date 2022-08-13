#include <bits/stdc++.h>

using namespace std;
#define X first
#define Y second


int board[102][102];
int board2[102][102];

vector<pair<int,int>> cctv;
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1}

int n, m;

bool OOB(int a, int b){
    return a<0||a>=n||b<0||b>=m;
}

void upd(int x, int y, int dir){
    dir %= 4;
    while(1){
        x += dx[dir];
        y += dy[dir];
        if(OOB(x,y) || board2[x][y] ==6) return;
        if(board2[x][y] != 0) continue;
        board2[x][y] = 7;
    }
}

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;


    int mn = 0;



    queue<pair<int,int>> Q;
    for(int i = 0 ; i <n;i++){
        for(int j = 0 ; j < m;j++){
            cin >> board[i][j];
            if(board[i][j] != 0 && board[i][j] != 6){
                cctv.push_back({i,j});
            }
            if(board1[i][j] == 0) mn++;
        }   
    }

    for(int tmp = 0; tmp < (1<<(2*cctv.size())); tmp++){
        for(int i = 0 ; i <n;i++)
            for(int j = 0 ; j < m;j++)
                board2[i][j] = board1[i][j];
        int brute = tmp;
        for(int i = 0; i < cctv.size(); i++){
            int dir = brute %4;
            brute /=4;
            int x = cctv[i].X;
            int y = cctv[i].Y;
            if(board1[x][y] == 2){
                upd(x,y,dir);
                upd(x,y,dir+2);
            }
            else if(board1[x][y] == 3){
                upd(x,y,dir);
                upd(x,y,dir+1);
            }
            else if(board1[x][y] == 4){
                upd(x,y,dir);
                upd(x,y,dir+1);
                upd(x,y,dir+2);
            }else{
                upd(x,y,dir);
                upd(x,y,dir+1);
                upd(x,y,dir+1);
                upd(x,y,dir+3);
            }
        }
        int val = 0;
        for(int i = 0 ; i <n;i++)
            for(int j = 0 ; j < m;j++)
            val += (board2[i][j] == 0);
        mn = min(mn,val);
    }
    cout << mn;;
}