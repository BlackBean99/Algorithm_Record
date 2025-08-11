#include <iostream>
#include <vector>

using namespace std;

void printAll(vector<int> arr){
    int arrSize = arr.size();
    for(int i = 0 ; i < arrSize; i++){
        cout << arr[i] << '\n';
    }
}

void process(int n){
    vector<int> answer;
    for(int i = 2; i*i < n; i++){
        if(n % i == 0){
            while(n % i == 0){
                n = n / i;
                answer.push_back(i);
            }
        }
        else{
            continue;
        }
    }
    if(n != 1){
        answer.push_back(n);    
    }
    printAll(answer);
}
// 소인수를 오름차순으로 출력한다.
int main(){
    // cin 같이 입출력 함수를 하나만 사용시 오버헤드를 줄여주는 꿀 코드
    ios::sync_with_stdio(false);
    // 넹 찾아볼게여. 버퍼 비워주는거 ㅇㅋㅇㅋ 찾아볼게여
    cin.tie(NULL);
    int n;
    cin >> n;
    process(n);
    return 0;
}