#include <bits/stdc++.h>

using namespace std;

tuple<int,int,int> edge[1004];
//  노드 node 개수
int n;
// 간선 edge
int e;
vector<int> p(303,-1);

int find(int x){
    if(p[x] < 0) p[x] = x;
    return p[x] = find(p[x]);
}

bool is_diff_group(int u, int v){
    u = find(u);
    v = find(v);
    //  같은 노드를 비교시
    if(u == v) return 0;
    // 다른 그룹일때
    if(p[u] == p[v]) p[u]--;
    if(p[u] < p[v]) p[v] = u;
    else p[u] = v;
    return 1;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    // 자신에게 가는 비용은 따로 입력 받는다.
    for(int i = 1; i<=n;i++){
        int cost;
        cin >> cost;
        edge[e++] = {cost, i, n+1};
    }
    for(int i = 1; i<=n;i++){
        for(int j = 1; j<=n;j++){
            int cost;
            cin >> cost;
            if(i>=j) continue;
            edge[e++] = {cost, i,j};
        }
    }
    n++;
    sort(edge,edge+e);
    int cnt = 0;
    int ans = 0;
    // 모든 간선에서 가장 짧은 가중치를 선택한다.
    for(int i = 0;i<e;i++){
        int a,b,cost;
        tie(cost, a, b) = edge[i];
        if(!is_diff_group(a,b)) continue;
        ans += cost;
        cnt++;
        if(cnt == n-1) break;
    }
    cout << ans;
}
