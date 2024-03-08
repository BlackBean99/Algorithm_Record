#include <bits/stdc++.h>
using namespace std;

int dist[100002];
int n, k;
// *2, +1, -1 로 이동이 가능하다. 가장 최소의 움직임의 경로를 선택해보자

//  backtracking 해보자
int pre[100002];
int main(void){
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> n >> k;
    fill(dist, dist + 100001, -1);
    dist[n] = 0;
    queue<int> Q;
    Q.push(n);
    while(dist[k] == -1){
        int cur = Q.front(); Q.pop();
        for(int nxt : {cur-1, cur + 1, cur *2}){
            if(nxt < 0 || nxt > 100000) continue;
            if(dist[nxt] != -1) continue;
            dist[nxt] = dist[cur] + 1;
            pre[nxt] = cur;
            Q.push(nxt);
        }
    }
    int index = k;
    vector<int> path;
    path.push_back(k);
    while(index != n){
        path.push_back(pre[index]);
        index = pre[index];
    }
    for(int value : path) cout << value << ' ';
}