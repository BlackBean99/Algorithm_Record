#include <bits/stdc++.h>
using namespace std;

vector<int> p(303,-1);

int find(int x){
  if(p[x] < 0) return x;
  return p[x] = find(p[x]);
}

// 같은 그룹을 간선으로 연결하면 싸이클이 형성되기 떄문이다.
bool is_diff_group(int u, int v){
    // 처음 부른 그룹은 자기 노드로 그룹으로 초기화한다.
  u = find(u); v = find(v);
//    같은 노드를 비교시
  if(u == v) return 0;
    // 같은 그룹일때,
  if(p[u] == p[v]) p[u]--;
//   v그룹이 더 클때, 같은 그룹으로 바꾼다.
  if(p[u] < p[v]) p[v] = u;

  else p[u] = v;
  return 1;
}

int v, e;
tuple<int,int,int> edge[100005];

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  cin >> v;
  // 가상의 v+1번째 정점과 연결
  for(int i = 1; i <= v; i++){
    int cost;
    cin >> cost;
    edge[e++] = {cost, i, v+1};
  }

  for(int i = 1; i <= v; i++){
    for(int j = 1; j <= v; j++){
      int cost;
      cin >> cost;
      if(i >= j) continue;
      edge[e++] = {cost, i, j};
    }
  }
  v++; // 가상의 정점까지 포함해야 하므로 정점 수를 1 증가시킴
  sort(edge, edge + e);
  int cnt = 0;
  int ans = 0;
  for(int i = 0; i < e; i++){
    int a, b, cost;
    tie(cost, a, b) = edge[i];
    if(!is_diff_group(a, b)) continue;
    // 가중치가 최소인 간선만 먼저 넣는다.
    ans += cost;
    cnt++;
    if(cnt == v-1) break; 
  }
  cout << ans;
}