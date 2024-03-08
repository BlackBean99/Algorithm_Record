#include <stdio.h>
#include <vector>
#include <algorithm>
#include <iostream>
#include <time.h>

using namespace std;

int gcd(int a, int b){
    int n;
    int tmp;
    if(a < b){
    // a 가 더 작으면 b와 교체해서 a가 더 크게 만든다.
        tmp = a;
        a = b;
        b = tmp;
    }
    while(b!=0){
        n = a % b;
        a = b;
        b = n;
    }
    return a;
}

int main(){
    int N, M;
    cin >> N >> M;
    int ret = gcd(N,M);
    cout << ret;
    return 0;
}