#include <bits/stdc++.h>

using namespace std;

int a[50];
int b[50];
int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i = 0; i <n;i++)
        cin >> a[i];
    for(int i = 0; i <n;i++)
        cin >> b[i];
    sort(a, a+n);
    sort(b, b+n);
    int ans = 0;
    for(int i =0;i<n;i++){
        ans += a[i] * b[n-1-i];
    }
    cout << ans;
}