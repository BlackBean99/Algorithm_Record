// 문제
// 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 
// 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

// 입력
// 첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
//  두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)

// 6 5
// 1 1 0 1 1
// 0 1 1 0 0
// 0 0 0 0 0
// 1 0 1 1 1
// 0 0 1 1 1
// 0 0 1 1 1

// BOJ 1927 그림
#include <bits/stdc++.h>
using namespace std;
#define X first
#define Y second // pair에서 first, second를 줄여서 쓰기 위해서 사용

int board[502][502];
int vis[502][502];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int n, m;
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int num = 0;
    int mx = 0;
    int area = 0;
    // 입력받기
    cin >> n >> m;
    // board 입력하기
    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin >> board[i][j];
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){ // (i, j)를 시작점으로 하고 싶은 상황
        if(board[i][j] == 0 || vis[i][j]) continue; // 해당 칸이 색칠이 안된 부분(0)이거나 이미 (i, j)를 방문했을 경우 넘어감
        // (i,j)는 새로운 그림에 속해있는 시작점
        num++; // 그림의 수 1 증가
        queue<pair<int,int> > Q;
        vis[i][j] = 1; // (i,j)로 BFS를 시작하기 위한 준비
        Q.push({i,j});
        int area = 0; // 그림의 넓이
            while(!Q.empty()){
                area++;
                // 상하좌우를 하나씩 체크한다.
                pair<int,int> cur = Q.front();
                Q.pop();
                for(int dir = 0; dir < 4; dir++){ // 상하좌우 칸을 살펴볼 것이다.
                    int nx = cur.X + dx[dir];
                    int ny = cur.Y + dy[dir]; // nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue; // 범위 밖일 경우 넘어감
                    if(vis[nx][ny] || board[nx][ny] != 1) continue; // 이미 방문한 칸이거나 파란 칸이 아닐 경우
                    vis[nx][ny] = 1; // (nx, ny)를 방문했다고 명시
                    Q.push({nx,ny});
                }
            }
            mx = max(mx, area);
        }
    }
    cout << num << "\n" << mx;
}