#include <bits/stdc++.h>

using namespace std;

int n, m;
int a[5];
int b[5];
int c[12];

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cin >> n >> m;
    for(int i = 0;i<n;i++)
        cin >> a[i];
    for(int i = 0;i<m;i++)
        cin >> b[i];

    int aidx=0;
    int bidx=0;
    for(int i=0;i < n+m; i++){
        if(bidx == m) c[i] = a[aidx++];
        else if(aidx == n) c[i] = b[bidx++];
        else if(a[aidx] <= b[bidx]) c[i] = a[aidx++];
        else c[i] = b[bidx++];
    }
   for(int i =0; i<m+n; i++)
        cout << c[i] << " "; 
}