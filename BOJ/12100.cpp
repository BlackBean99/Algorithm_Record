#include <bits/stdc++.h>

using namespace std;

int n;
int board1[10][10];
int board2[10][10];
void rotate(){
    int tmp[21][21];
    for(int i =0;i<n;i++)
        for(int j =0;j<n;j++)
            tmp[i][j] = board1[i][j]; 
    for(int i =0;i<n;i++)
        for(int j =0;j<n;j++)
            board2[i][j] = tmp[n-j-1][i];
}

void tilt(int dir){
    while(dir--) rotate();
    // 복구
    for(int i =0;i<n;i++){
        int tilted[21] = {};
        int idx = 0;
        for(int j =0;j<n;j++){
            if(board2[i][j] == 0) continue;
            else if(tilted[idx] == 0) tilted[idx] = board2[i][j];
            else if(tilted[idx] == board2[i][j]) tilted[idx]*2;
            else tilted[++idx] = board[i][j];
        }
        for(int j = 0; i <n; i++)
            board2[i][j] = tilted[i][j];        
    }
}
    

int main(void){
    cin >> n;
    // 5번의 방향 정하기
    for(int i =0;i<n;i++){
        for(int j =0;j<m;j++){
        cin >> board1[i][j];
        }
    }
    for(int tmp = 0;tmp < 1<((2*(1<<5))); tmp++){
        // 초기화
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++)
                board2[i][j] = board1[i][j];
        for(int i =0;i<5;i++){
            int dir = tmp%4;
            brute /= 4;
            tilt(dir);
        }
        
        for(int i =0;i<n;i++)
            for(int j =0;j<m;j++)
                mx = max(mx, board2[i][j]);
    }
    cout << mx;
}