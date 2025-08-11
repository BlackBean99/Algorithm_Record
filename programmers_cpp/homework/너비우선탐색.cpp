#include<iostream>
#include<queue>
using namespace std;

int map[10][10]={0};
int visit[10]={0};
queue<int> q;
int num, edge_num;

void bfs(int v){
    cout<<v<<"\n";
    q.push(v);
    while(!q.empty()){
        int node = q.front();
        q.pop();
        // 각 원소들을 하나씩 순회하면서
        for(int i=0;i<num;i++){
            //  존재하는 경로이면서, 지나지 않은 경로인 경우에만 순회.
            if(map[node][i]==1 && visit[i]==0){
                visit[node]=1;
                cout<<i<<"\n";
                // 그 원소를 queue에 enqueue한다.
                q.push(i);
            }
        }
    }
}

int main(){
    cin>>num>>edge_num;
    for(int i=0;i<edge_num;i++){
        int v1,v2;
        cin>>v1>>v2;
        map[v1][v2]=map[v2][v1]=1;
    }
    bfs(1);
    return 0;
}