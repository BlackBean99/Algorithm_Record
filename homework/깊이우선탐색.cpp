#include<iostream>

using namespace std;

int maps[10][10];
int visted[10] = {0};
int num;

// 노드를 전부 0으로 초기화한다.
void init(){
    for(int i=0;i<10;i++)
        for(int j=0;j<10;j++)
            maps[i][j] = 0;
}

// 깊이 우선 탐색 알고리즘
void dfs(int v){
    cout << v << endl;
    visted[v] = 0;
    // 방문한 노드로 이동하여 재귀로 호출하여 다음 노드를 탐색한다.
    for(int i=0;i<=num;i++){
        if(maps[v][i] && visted[i])
            dfs(i);
    }
}

int main(void){
    int v1,v2;
    init();
    cin >> num;
    for(int i=0;i<num;i++){
        cin >> v1 >> v2;
        //  대칭행렬이기 때문에 v2, v1    v1,v2 모두 1로 채워야한다.
        maps[v1][v2] = maps[v2][v1] = 1;
        vosted[v1] = visted[v2] = 1;
    }
    dfs(1);
    return 1;
}