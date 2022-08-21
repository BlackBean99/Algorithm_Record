#include <bits/stdc++.h>

using namespace std;

//  두개의 합을 two에 저장한다.
// a[i] + a[j] + a[k] = a[l];을 만족하는 a[l] 중에서 최댓값.
int a[10005];
int n;
vector<int> two;
int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i =0;i<n;i++) cin >> a[i];
    sort(a,a+n);
    for(int i =0;i<n;i++){
        for(int j =i;j<n;j++){
            two.push_back(a[i] + a[j]); 
        }
    }
    sort(two.begin(),two.end());
    for(int i = n-1;i>0;i--){
        for(int j = 0;j<i;j++){
            if(binary_search(two.begin(),two.end(),a[i]-a[j])){
                cout << a[i];
                return 0;
            }
        }
    }
}