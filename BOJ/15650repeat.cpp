
#include <bits/stdc++.h>

using namespace std;

int n, m;

bool visited[102];
int arr[102];
// 순열을 중복 없이 하나씩 길이가 m개가 되면 출력
void proc(int num, int cnt){
    // basecondition
    if(cnt == m){
        for(int i = 0 ; i <m;i++)
            cout << arr[i] << ' ';
        cout << endl;
        return;
    }
    for(int i = num; i <= n; i++){
        // 재귀 전
        if(!visited[i]){
            visited[i] = true;
            arr[cnt] = i;
            proc(i, cnt+1);
            // 재귀 후처리
            visited[i] = false;
        }
    }
}

//  순열
int main(void){
    cin >> n >> m;
    proc(1,0);
}