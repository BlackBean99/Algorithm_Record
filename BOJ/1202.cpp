#include <bits/stdc++.h>

#define X first
#define Y second

using namespace std;
// 보석 n개
int n;

pair<int,int> jewel[1000000];
// 보석 무게 M 과 가격 V 를 담는 map
multiset<int> bag;
// 가방의 개수k와 각 가방에 담을 수 있는 최대 무게 c
int k,c;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> k;
    for(int i = 0; i < n; i++)
        cin >> jewel[i].Y >> jewel[i].X;
    //  무게순으로 정렬
    sort(jewel, jewel+n);

    while(k--){
        int tmp;
        cin >> tmp;
        // multiset이라 오름차순으로 자동 정렬됨
        bag.insert(tmp);
    }

    long long ans = 0;
    // 무거운 보석부터
    for(int i = n-1; i >= 0 ;i--){
        int m, v;
        tie(v,m) = jewel[i];
        // 해당 보석을 담을 수 있는 가방중 가장 작은 가방을 찾는 것
        auto it = bag.lower_bound(m);
        // 최대 무게가 m이상인 가방이 없다는 의미
        if(it == bag.end()) continue;
        ans += v;
        bag.erase(it);
    }
    cout << ans;
}