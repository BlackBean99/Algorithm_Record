#include <bits/stdc++.h>

using namespace std;
#define X first
#define Y second


int board[102][102];
int processedBoard[102][102];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1}

int visited[102][102];
int n, m;

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;

    queue<pair<int,int>> Q;
    for(int i = 0 ; i <n;i++){
        for(int j = 0 ; j < m;j++){
            cin >> board[i][j];
            if(board[i][j] != 0 || board[i][j] != 6){
                Q.push({i,j});
            }
        }   
    }

    while(!Q.empty()){
        pair<int,int> cur = Q.front(); Q.pop();
        
        for(int dir = 0 ; dir < 4; dir++){
            // nx 0
           
                while(!board[nx][ny] == 6 || !Q.empty()){
                     if(board[cur.X][cur.Y] ==1){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny <0 || ny >= m)
                        break;
                    if(board[nx][ny] == 0)
                        Q.push({nx,ny});
                        processedBoard[nx][ny] = -1;
                    if(board[nx][ny] != 0)
                        continue;
                }
            }
            // nx 0,2
            if(board[cur.X][cur.Y] ==2){
                while(!board[nx][ny] == 6){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny <0 || ny >= m)
                        break;
                    if(board[nx][ny] == 0)
                        processedBoard[nx][ny] = -1;
                        int AdirX = (dir+2)%4;
                        int AdirY = (dir+2)%4;
                        processedBoard[AdirX][AdirY] = -1;
                    if(board[nx][ny] != 0)
                        continue;
                }
            }
            // nx 0,1
            if(board[cur.X][cur.Y] ==3){
                while(!board[nx][ny] == 6){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny <0 || ny >= m)
                        break;
                    if(board[nx][ny] == 0)
                        processedBoard[nx][ny] = -1;
                        int AdirX = (dir+1)%4;
                        int AdirY = (dir+1)%4;
                        processedBoard[AdirX][AdirY] = -1;
                    if(board[nx][ny] != 0)
                        continue;
                }
            }
            // nx 0,1,2
            if(board[cur.X][cur.Y] ==4){
                while(!board[nx][ny] == 6){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny <0 || ny >= m)
                        break;
                    if(board[nx][ny] == 0)
                    // 0
                        processedBoard[nx][ny] = -1;
                    // 1
                        int AdirX = (dir+1)%4;
                        int AdirY = (dir+1)%4;
                        processedBoard[AdirX][AdirY] = -1;
                    // 2
                        int BdirX = (dir+2)%4;
                        int BdirY = (dir+2)%4;
                        processedBoard[BdirX][BdirY] = -1;
                    if(board[nx][ny] != 0)
                        continue;
                }
            }
            // nx 0,1,2,3
            if(board[cur.X][cur.Y] ==5){
                while(!board[nx][ny] == 6){
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir];
                    if(nx < 0 || nx >= n || ny <0 || ny >= m)
                        break;
                    if(board[nx][ny] == 0)
                    // 0
                        processedBoard[nx][ny] = -1;
                    // 1
                        int AdirX = (dir+1)%4;
                        int AdirY = (dir+1)%4;
                        processedBoard[AdirX][AdirY] = -1;
                    // 2
                        int BdirX = (dir+2)%4;
                        int BdirY = (dir+2)%4;
                        processedBoard[BdirX][BdirY] = -1;
                    // 3
                        int CdirX = (dir+3)%4;
                        int CdirY = (dir+3)%4;
                        processedBoard[CdirX][CdirY] = -1;
                            
                    if(board[nx][ny] != 0)
                        continue;
                }
            }
        }
    }
    int cnt = 0;
    for(int i = 0;i<m;i++)
        for(int j = 0;j<m;j++)
            if(processedBoard[i][j] == -1)
                cnt++;
    cout << cnt++;
}