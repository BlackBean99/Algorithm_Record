#include <bits/stdc++.h>

using namespace std;

vector<int> adj[1005];
bool vis[1005];
int st;

void bfs(){
        queue<int> q;
        q.push(st);
        vis[st] = true;
        while(!q.empty()){
            int cur = q.front();
            cout << cur << ' ';
            q.pop();
            for(auto x : adj[cur]){
                if(vis[x]) continue;
                q.push(x);
                vis[x] = true;
        }
    }
}

// 작은 정점을 먼저 방문해야한다.
void dfs(int cur){
    vis[cur] = true;
    cout << cur << ' ';
    for(auto nxt : adj[cur]){
        if(vis[nxt]) continue;
        dfs(nxt);
    }
}

int main(void){
    int n, m;
    cin >> n >> m >> st;
    while(m--){
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for(int i = 0;i<=n;i++)
        sort(adj[i].begin(), adj[i].end());
    dfs(st);
    cout << '\n';
    fill(vis+1, vis+1+n,false);
    bfs();
}