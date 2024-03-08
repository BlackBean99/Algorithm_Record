#include <bits/stdc++.h>

using namespace std;
int n,m;

vector<int> adj[100001];
int deg[10001];
int main(void){
    cin >> n >> m;
    fill(deg,deg+10001,0);
    while(m--){
        int a,b;
        cin >> a >> b;
        adj[a].push_back(b);
        deg[b]++;
    }

    queue<int> q;
    for(int i = 1;i<=n;i++){
        if(deg[i] == 0) q.push(i);
    }

    while(!q.empty()){
        int cur = q.front();q.pop();
        cout << cur << ' ';
        for(int x : adj[cur]){
            deg[x]--;
            if(deg[x] == 0) q.push(x);
        }
    }
}