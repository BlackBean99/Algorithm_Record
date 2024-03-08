// N과 M
// N개의 자연수를 M개의 길이의 수열로 표현

#include <bits/stdc++.h>
using namespace std;

int n,m;

int arr[10];
bool visited[10];

void permutation(int depth){
// base condition
// N개의 자연수중 M개가 완성되면 표현
    if(depth == m){
        for(int i = 0 ; i < m; i++)
            cout << arr[i] << ' ';
        cout << "\n";
        return;
    }
// 하나씩 방문해서 정답에 입력하고 방문표시를 한다.
//  방문이 끝나면 방문 표시를 해제한다.
    for(int i =1;  i <= n; i++){
        if(!visited[i]){
            arr[depth] = i;
            visited[i] = 1;
            permutation(depth + 1);
            // backtracking
            visited[i] = 0;
        }
    }
}


int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    permutation(0);    
} 