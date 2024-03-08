#include <bits/stdc++.h>
#include <map>
#include <iostream>
/**
|2^62| 크기의 N 장을 가지고 있다.
가장 많이 가지고 있는 정수를 구하는 프로그램을 작성해라
*/

using namespace std;
long long a[100005];

int main(void){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i =0;i<n;i++){
        cin >> a[i];
    }
    sort(a,a+n);
    int cnt = 0;
    long long mxval = -(1ll <<62)-1;
    int mxcnt = 0;
    for(int i =0;i<n;i++){
        if(i ==0 || a[i-1] == a[i]) cnt++;
        else{
            if(cnt > mxcnt){
                mxcnt = cnt;
                mxval = a[i-1];
            }
            cnt = 1;
        }
    }
    if(cnt > mxcnt) mxval = a[n-1];
    cout << mxval;
}
    // map<int,int> cards;
    // map<int,int>::iterator it;
    // cin >> n;
    // for(int i =0;i<n;i++){
    //     int tmp;
    //     cin >> tmp;
    //     cards[tmp]++;
    // }
    // long long max = 0;
    // int idx;
    // for(it = cards.begin();it!=cards.end();it++){
    //     if(it->second > max){
    //         max = it->second;
    //         idx = it->first;
    //     }
    // }
    // cout << idx;

// 7795