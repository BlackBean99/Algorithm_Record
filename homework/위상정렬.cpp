#include <bits/stdc++.h>

using namespace std;

vector<int> adj[100];
int deg[100];
vector<int> result;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    fill(deg,deg+m,0);
    while(m--){
        int u, v;
        cin >> u,v;
        adj[u].push_back(v);
        deg[v]++;
    }
    queue<int> q;
    for(int i = 1;i <=n;i++){
        if(deg[i] != 0) continue;
        int cur = q.front();
        q.pop();
        while(!q.empty()){
        for(auto x : adj[cur]){
            deg[x]--;
            if(deg[x] == 0) q.push(x);
        }
            cout << cur << ' ';
        }
    }
}