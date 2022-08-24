#include <bits/stdc++.h>

using namespace std;

#define X first
#define Y second
// {weight, destination}
vector<pair<int,int>> adj[1000];
int u,v,st;
int dist[10000];
int INF = 0x3f3f3f3f;
int main(void){

    cin >> u >> v >> st;

    while(v--){
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({c,b});
    }
    fill(dist, dist + u + 1, INF);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<vector<int,int>> > pq;
    dist[st] = 0;
    pq.push({dist[st], st});
    while(!pq.empty()){
        auto cur = pq.top(); pq.pop();
        // 바로가는 거 보다 돌아가는게 더 좋을때
        if(dist[cur.Y] < cur.X) continue;
        for(auto nxt : adj[cur.Y]){
            // nxt  : X최단거리, Y노드
            if(dist[nxt.Y] <= dist[cur.Y] + nxt.X) continue;
            dist[nxt.Y] = dist[cur.Y] + nxt.X;
            pq.push({dist[nxt.X],nxt.Y});
        }
    }
    for(int i = 1; i <= u;i++){
        if(dist[1] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }
}
