#include <bits/stdc++.h>
using namespace std;


// a 에서 b로 n개를 이동한다.
void func(int a, int b, int n){
    // base condition
    if(n==1){
      cout << a << ' ' << b << '\n'; 
        return;
    }    
    //  n-1 개의 원판을 기둥 a 에서 6-a-b 로 옮긴다.
    func(a, 6-a-b, n-1);
    // n 번쨔 원판을 b로 옮긴다.
    cout << a << ' ' << b << '\n'; 
    //  n-1개의 원판을 기둥 6-a-b 에서 기둥 b로 옮긴다.  
    func(6-a-b, b, n-1);
}

int main(void){
    int n;
    cin >> n;
    cout << (1<<n) -1 << '\n';
    func(1,3,n);
}