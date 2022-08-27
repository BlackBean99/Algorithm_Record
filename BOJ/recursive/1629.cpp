#include <bits/stdc++.h>
using namespace std;

using ll = long long;


// 연수 A를 B번 곱한 수를 알고 싶다. 
// 단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
ll POW(ll a, ll b, ll m){
    //  base condition
    if(b == 1) return a %m ;
    //  b 가 짝수인 경우
    ll val = POW(a, b/2, m);
    val = val * val %m;
    if(b % 2) return val; 
    return val * a % m;
}

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);
    ll a,b,c;
    cin >> a >> b >> c;
    cout << POW(a,b,c);
}