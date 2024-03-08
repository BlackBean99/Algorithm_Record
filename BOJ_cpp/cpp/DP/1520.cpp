#include <bits/stdc++.h>
#define MAX 501

using namespace std;

int dp[MAX][MAX];
int board[MAX][MAX];
int n, m, ans;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};

int dfs(int x, int y){
	// base condition
	if( x == 0 && y ==0 ) return 1; // base condition
	if( x < 0 && x >= n && y < 0 && y >= m) return 0; // 없는 좌표
	if(dp[x][y] != -1) return dp[x][y];  // 값이 이미 있는 경우
	
	dp[x][y] = 0;

	for(int dir = 0; dir < 4; dir++){
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if(board[nx][ny] > board[x][y]){
			dp[x][y] += dfs(nx,ny);
		}
	}
	return dp[x][y];
}

int main(void){
	cin.tie(0);
	ios::sync_with_stdio(0);

	cin >> n >> m;
	for(int i = 0;i<n;i++){
		for(int j = 0;j<m;j++){
			cin >> board[i][j];
			dp[i][j] = -1;
		}
	}
	ans = dfs(n-1,m-1);
	cout << ans;
} 