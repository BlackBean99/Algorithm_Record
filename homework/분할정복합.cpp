#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

int main(){
    // cin, cout 속도 향상을 위해 동기화 해제   
    ios_base::sync_with_stdio(false);

    // 종료조건
    if(n==1) return 1;
    //  홀수일 경우
    if(n%2 == 1) return n+ fastSum(n-1);

    // 짝수인 경우, n/2
    return (n/2)*(n/2) + fastSum(n/2);
}