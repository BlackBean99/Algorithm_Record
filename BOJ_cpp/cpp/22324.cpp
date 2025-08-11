#include <bits/stdc++.h>

using namespace std;

// 정점, 간선, k 번째 간선은 1이다.

int n, m, k;
int dist[1000][1000];
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int INF = 1000;
    cin >> n >> m >> k;

    for(int i = 1; i <= n;i++) fill(dist[i],dist[i]+1+n, INF);

    for(int i = 0; i < m;i++){
        int a, b;
        cin >> a >> b;
        if(i==k-1){
            dist[a][b] = 1;
            dist[b][b] = 1;
            continue;
        }
        dist[a][b] = 0;
        dist[b][a] = 0;
    }

    for(int k =1; k<= n; k++)
        for(int i =1; i<= n; i++)
            for(int j =1; j<=n; j++){
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
    
    int ans = 0;
    for(int i = 1;i<n;i++){
        for(int j = i+1;j <n+1;j++){
            ans += dist[i][j];
        }
    }
    cout << ans;
    cout << endl;
}