#include <bits/stdc++.h>

using namespace std;
int board1[21][21];
int board2[21][21];
int n;

void rotate(){
    int tmp[21][21];
    for(int i = 0;i<n;i++)
        for(int j = 0;j<n;j++)
         tmp[i][j] = board2[i][j];
    for(int i = 0;i<n;i++)
        for(int j = 0;j<n;j++)
         board2[i][j] = tmp[n-1-j][i];
}
// 1. 게임판 기울이기
void tilt(int dir){
    int idx = 0;
    // 원래 방향으로 돌리지 않아도 그 결과를 도출할 수 있기 때문이다.
    while(dir--) rotate();
    for(int i = 0 ; i <n;i++){
        int tilted[21] = {}; //왼쪽으로 기울인 결과를 저장할 변수
        int idx = 0; // tilted 배열에서 어디에 삽입해야 하는지 가리키는 변수
        for(int j = 0; j<n;j++){
            if(board2[i][j] ==0) continue;
            if(tilted[idx] == 0) // 삽입할 위치가 비어있다.
                tilted[idx] = board2[i][j];
            else if(tilted[idx] == board1[i][j]) //같은 값을 갖는 블록이 충돌할 경우
                tilted[idx] *= 2;
            else
                tilted[++idx] = board2[i][j]; // 다른 값을 갖는 블록이 충돌할 경우
        }
        for(int j = 0; j <n;j++) board2[i][j] = tilted[j];
    }
}
// 2. 게임판 다시 회전시켜놓기
int main(void){

    // 5번 기울이는 방향 정하기
    // 각 기울이는 방향의 선택지가 4개이므로 4^5 번 시행해봐야한다.
    int mx = 0;
    for(int tmp = 0;tmp < (1<<5); tmp++ ){
        for(int i = 0;i<n;i++)
            for(int j = 0;j<n;j++)
                board2[i][j] = board1[i][j];
        int brute = tmp;
        for(int i = 0; i< 5;i++){
            int dir = brute %4;
            brute /=4;
            tilt(dir);
        }
        for(int i =0; i <n;i++)
            for(int j = 0;j<n;j++)
                mx = max(mx,board2[i][j]);
    }
    cout << mx;
}