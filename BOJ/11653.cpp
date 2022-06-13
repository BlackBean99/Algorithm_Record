#include <iostream>
#include <vector>
#include <cmath>


using namespace std;

void printAll(vector<int> arr){
    for(int i = 0 ; i < arr.size();i++){
        cout << arr[i] << endl;
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
    int n;
    cin >> n;
    process(n);
    return 0;
}