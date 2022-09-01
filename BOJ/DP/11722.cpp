#include <bits/stdc++.h>

using namespace std;

int INF = 0xffffff;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    vector<int> arr;
    while(n--){
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }
    vector<int> ans[n];

    for(int i = n-1;i >= 0; i--){
        int minValue = INF;
        if(i == n-1) {
            ans[arr[i]].push_back(arr[i]);
            continue;
        }
        ans[arr[i]].push_back(arr[i]);
        for(int j = i+1;j<n;j++){
            if(arr[i] > arr[j]){ 
                minValue = arr[j];
                if(min)
                ans[arr[i]].push_back(arr[j]);
            }
        }
    }

}