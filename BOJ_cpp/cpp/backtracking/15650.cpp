#include <bits/stdc++.h>
using namespace std;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
*/
#define MAX 9
int arr[MAX] = {0,};
bool visited[MAX] = {0,};
int n,m;

void get_permutation(int num,int cnt){
    // base condition
    if(cnt == m){
        for(int i = 0; i < m; i++)
            cout << arr[i] << ' ';
        cout << "\n";
        return;
    }
    for(int i = num; i<= n;i++){
        if(!visited[i]){
            visited[i] = true;
            arr[cnt] = i;
            get_permutation(i+1, cnt+1);
            arr[cnt] = 0;
            visited[i] = false;
        }
    }
}


int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n >> m;

    // fill(visited,visited+m,false);
    get_permutation(1,0);
}