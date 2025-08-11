#include <bits/stdc++.h>

using namespace std;

int w[100000];
int main(void){
    int n;
    cin >> n;
    for(int i =0; i <n; i++){
        cin >> w[i];
    }
    sort(w,w+n);
    int maxValue = 0;
    for(int i = 1; i<=n; i++){
        maxValue = max(maxValue,w[n-i]*i);
        }
    cout << maxValue;
}