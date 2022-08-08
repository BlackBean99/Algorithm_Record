#include <stdio.h>
#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;  


int main(){
    int caseSize;
    vector<int> array;

    cin >> caseSize;
    int cnt = 0;

    //  데이터 입력
    for(int i = 0; i < caseSize; i++){
        int tmp;
        cin >> tmp;
        array.push_back(tmp);
    }
    sort(array.begin(),array.end());

    while(1){
        // break Condition
        if(array.size() ==1){
            break;
        }
        array[array.size()-2] += array[array.size()-1];
        array.pop_back();
        cnt++;
        array[0]--;

        if(array[0] == 0){
            for(int i = 0; i < array.size()-1; i++){
                array[i] = array[i+1];
            }
            array.pop_back();
        }
    }
    cout << cnt;    
}