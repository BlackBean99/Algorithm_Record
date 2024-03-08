#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int MAX = 1000;
bool visit[MAX];
vector<int> adj[MAX];
queue<int> Q;
int cnt = 0;

int main(void){

    int n, k;
    cin >> n;
    cin >> k;

    int start_point_x = 0;

    for (int i = 0; i < k; ++i) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
        if(i == 0){
            start_point_x  = a;
        }
    }
    visit[start_point_x] = true;
    Q.push(start_point_x);
    while (!Q.empty()) {
        int x = Q.front();
        Q.pop();
        for (int i = 0; i < adj[x].size(); ++i) {
            int next = adj[x][i];
            if (!visit[next]) {
                cnt++;
                visit[next] = true;
                Q.push(next);
            }
        }
    }
    cout << cnt;
}

