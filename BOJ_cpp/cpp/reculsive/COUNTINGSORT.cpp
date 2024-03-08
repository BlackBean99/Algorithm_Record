#include <bits/stdc++.h>

using namespace std;

int n;
int arr[2000000];

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;

    for(int i =0;i<n;i++){
        int a;
        cin >> a;
        arr[a+1000000]++;
    }
    for(int i = 0; i <2000000;i++){
        while(arr[i]--){
            cout << i-1000000 << ' ';
        }
    }
}