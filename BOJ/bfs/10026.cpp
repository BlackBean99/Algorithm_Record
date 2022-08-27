#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second

// R=G, B/ R,G,B
int n;
char table[1000][1000];
char table2[1000][1000];
bool visit[1000][1000];

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

queue<pair<int,int>> Q;
int ans = 0;
int ans2 = 0;

void bfs(){
    while(!Q.empty()){
        auto cur = Q.front(); Q.pop();

        for(int dir = 0; dir < 4; dir++){
        int nx = cur.X + dx[dir];
        int ny = cur.Y + dy[dir];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if(visit[nx][ny] == 1) continue;
        if(table[nx][ny] != table[cur.X][cur.Y]) continue;
        Q.push({nx,ny});
        visit[nx][ny] = 1;
        }
    }
    ans++;
}


// void bfs2(){
//     while(!Q.empty()){
//         auto cur = Q.front(); Q.pop();

//         for(int dir = 0; dir < 4; dir++){
//         int nx = cur.X + dx[dir];
//         int ny = cur.Y + dy[dir];
//         if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
//         if(visit[nx][ny] == 1) continue;
//         if(table2[nx][ny] != table2[cur.X][cur.Y]) continue;
//         Q.push({nx,ny});
//         visit[nx][ny] = 1;
//         }
//     }
//     ans++;
// }



int main(void){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> table[i];
    }
    for(int i = 0; i < n; i++){
        fill(visit[i],visit[i]+n, 0);
    }
    // bfs 가 끝나면 ans ++

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(visit[i][j] == 1) continue;
            Q.push({i,j});
            bfs();
        }
    }
    cout << ans << ' ';

    // 방문여부 초기화
    for(int i = 0; i < n; i++){
        fill(visit[i],visit[i]+n, 0);
    }

    // 적록색맹인경우 판을 변경
    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            if(table[i][j] == 'G') table[i][j] = 'R';
    
    // 정답 초기화
    ans = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(visit[i][j] == 1) continue;
            Q.push({i,j});
            bfs();
        }
    }
    
    cout << ans;
}