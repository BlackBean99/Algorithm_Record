#include <bits/stdc++.h>
#include <vector>
#include <queue>
using namespace std;


int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int m, n;

vector<vector<int> > meltdown(vector<vector<int> > cur_matrix) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; ++j) {
            int cur_x = i;
            int cur_y = j;
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur_x + dx[dir];
                int ny = cur_y + dy[dir];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (cur_matrix[nx][ny] == 0) continue;
                cur_matrix[nx][ny]--;
            }
        }
    }
    return cur_matrix;
}

int custom_bfs(vector<vector<int> > cur_matrix) {
    queue<pair<int,int> > cur;
    int curCnt = 0;
    for(int i= 0; i < m; i++){
        for (int j = 0; j < n; ++j) {
            if(cur_matrix[i][j] == 0) continue;
            cur.push(make_pair(i,j));
            while(!cur.empty()){
                int cur_x = cur.front().first;
                int cur_y = cur.front().second;
                cur.pop();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = cur_x + dx[dir];
                    int ny = cur_y + dy[dir];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (cur_matrix[nx][ny] == 0) continue;
                    cur.push(make_pair(nx, ny));
                }
            }
            curCnt++;
    }
    return curCnt;
}


int main(void) {
    cin.tie(0);
    cin >> m >> n;
    vector<vector<int> > matrix(100, vector<int>(10,0));
    vector<vector<bool> > visit(100, vector<int>(10,false));
    for(int i= 0; i < m; i++){
        for (int j = 0; j < n; ++j) {
            cin >> matrix[i][j];
            visit[i][j] = false;
        }
    }
    vector<vector<int> > cur_matrix = matrix;

    int cnt = 0;
    while(cnt == 0){
        cur_matrix = meltdown(cur_matrix);
        cnt = custom_bfs(cur_matrix);
        if(cnt > 0){
            cout << cnt;
        }
    }
    return;
}
