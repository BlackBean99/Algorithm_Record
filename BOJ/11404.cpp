#include <bits/stdc++.h>

using namespace std;

int n, m;
int arr[105][105];
const int INF = 0x3f3f3f3f;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    // a to b cost c
    
    for(int i = 1; i <= n;i++) fill(arr[i],arr[i]+1+n, INF);
    
    while(m--){
        int a, b, cost;
        cin >> a >> b >> cost;
        arr[a][b] = min(cost, arr[a][b]);
    }
    for(int i = 1; i <= n;i++) arr[i][i] = 0;
        
    for(int i = 1; i <=n;i++){
        for(int j = 1;j <=n; j++){
            for(int z = 1; z<=n;z++){
                arr[j][z] = min(arr[j][z], arr[j][i] + arr[i][z]);
            }
        }
    }
        for(int i = 1; i <= n;i++){
            for(int j = 1;j <= n; j++){
                if(arr[i][j] == INF) cout << "0 ";
                else cout << arr[i][j] << ' ';
            }
            cout << '\n';
        }
}