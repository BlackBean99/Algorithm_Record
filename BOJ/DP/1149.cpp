#include <bits/stdc++.h>

using namespace std;


// 1번 집의 색은 2번과 달라야 한다.
// N번 집은 N-1 의 집과 색이 다르다.
//  i 번의 집은 i-1, i+1의 집과 달라야한다.

// 입력
// 각 집의 색칠하는 색에 따른 비용을 3개의 배열로 저장한다.
int n;
int cost[100][3];
int main(void){
    cin >> n;
    for(int i = 0 ; i <n ; i++){
        for(int j = 0 ; j <3 ; j++){
            cin >> cost[i][j];
        }
    }
    int minCost[50][50];
    // 기본값
    for(int i =0; i<3;i++){
        minCost[0][i] = cost[0][i];
    }

    for(int i = 1; i< n; i++){
        for(int j = 0; j < 3; j++)
            minCost[i][j] = min(minCost[i-1][(j+1)%3] + cost[i][j],minCost[i-1][(j+2)%3] + cost[i][j]);
    }
    int minValue = 1000;
    minValue = min(minCost[n-1][0], minCost[n-1][1]);
    minValue = min(minValue, minCost[n-1][2]);
    cout << minValue;
}