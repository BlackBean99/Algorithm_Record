//
// Created by 이서현 on 2023/01/01.
//
#include <vector>
#include <queue>
#include <iostream>

#define X first
#define Y second
using namespace std;


// 0은 북쪽 , 1은 동쪽, 2는 남쪽, 3은 서쪽
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
queue<pair<int,int> > Q;
int n, m;
int start_x, start_y;
int start_loc;
vector<vector<int> > map;
vector<vector<int> > visit(n, vector<int>(m, 0));
int cnt = 0;

void bfs(int loc) {
    while(!Q.empty()){
        pair<int, int> cur = Q.front();
        Q.pop();
        for (int dir = loc; dir < 4; ++dir) {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            cout << "nx :" << nx << endl;
            cout << "ny :" << ny << endl;

            if(nx < 0 || nx > n || ny < 0 || ny > m) continue;
            if(visit[nx][ny] != 0 || map[nx][ny] != 0) continue;
            Q.push(make_pair(nx, ny));
            visit[nx][ny] = 1;
            cnt++;
        }
    }
}

int main(void){
    cin >> n >> m;
    cin >> start_x >> start_y >> start_loc;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
            cin >> map[i][j];
        }
    }
    cout << map[1][1];

//    Q.push(pair<int,int> (start_x,start_y));
    Q.push(make_pair(start_x,start_y));
    cout << make_pair(1, 3).first;
    cout << Q.front().X << Q.front().Y;
    bfs(0);

    cout << cnt;
}
