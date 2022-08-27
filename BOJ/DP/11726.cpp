#include <bits/stdc++.h>

using namespace std;
int d[10005];
int mod = 10007;
int main(void){
    cin.tie(0);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    d[1] = 1;
    d[2] = 2;
    for(int i=3;i<=n;i++) d[i] = (d[i-1] + d[i-2])%mod;
    cout << d[n];
}#include <bits/stdc++.h>

using namespace std;
int d[10005];
int mod = 10007;
int main(void){
    cin.tie(0);
    ios::sync_with_stdio(false);
    int n;
    cin >>n;
    d[1] = 1;
    d[2] = 2;
    for(int i=3;i<=n;i++) d[i] = (d[i-1] + d[i-2])%mod;
    cout << d[n];
}