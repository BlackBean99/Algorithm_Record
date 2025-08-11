// 문제: N개의 정수 A1, A2, ..., AN 을 읽고, 이들 중에서 반복되는 수를 제외하고 남은 N'개의 수 B1, B2, ..., BN’ 을 입력된 순서대로 출력하시오. 이때,

// 0 ≤ Ai < 225 = 33554432, i=1,2,…,N.
// 입력의 개수 N은 1 이상 500만 이하이다.

/**
입력 : 12 1 449 12 555 1201 912 555 19372
출력 : 12 1 449 555 1201 912 19372
*/
#include <set>
#include <stdio.h>
#include <iostream>

using namespace std;
int main(){
    int tmp;
    set<int> s;
    while(cin >> tmp){
        if(s.count(tmp) > 0){

        }else{
            s.insert(tmp);
            cout << tmp << " ";
        }
        if(cin.get() == '\n') break;
    }
    return 0;
}