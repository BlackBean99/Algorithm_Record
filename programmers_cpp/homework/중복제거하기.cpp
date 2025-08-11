#include <iostream>
#include <set>

using namespace std;

// N 개의 정수가 차례대로 입력한다.
// 첫번째 INPUT 은 총 개수 , 다음 줄 부터 N줄에 거쳐서 한주렝 하나씩 입력을 받는다.
// 처음 등장한 숫자의 경우에는 OK, 이미 앞서 등장한 숫자의 경우 DUPLICATED
int main(){
    int N;
    cin >> N;

    // s 등장한 모든 정수를저장한 집합
    set<int> s;

    for(int i=0;i<N;i++){
        int X;
        cin >> X;

        if(s.count(X) > 0){
            printf("DUPLICATED\n");
        }
        else{
            s.insert(X);
            printf("OK\n");
        }
    }
    return 0;
}