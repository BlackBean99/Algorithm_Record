/*
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

*/
#include <bits/stdc++.h>

using namespace std;

bool isused1[102];
bool isused2[102];
bool isused3[102];

int n;
int cnt = 0;
// cur 은 몇번째 행에 놓을 것이냐.
void process(int cur){
    //  base condition
    if(cur == n){
        cnt++;
        return;
    }     

    for(int i = 0; i < n ; i ++){
        // Q 이 차지하고 있는 경우 pass
        if(isused1[i] || isused2[i+cur] || isused3[cur-i+n-1]) continue;

        isused1[i] = 1;
        isused2[i+cur] = 1;
        isused3[cur-i + n-1] = 1;
        process(cur + 1);
        
        isused1[i] = 0;
        isused2[i+cur] = 0;
        isused3[cur-i + n-1] = 0;
    }
}

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;

    process(0);
    cout << cnt;
}
