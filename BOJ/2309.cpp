// 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

// 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

// 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

// 20
// 7
// 23
// 19
// 10
// 15
// 25
// 8
// 13
// 20 7 23 19 10 13 8
// 일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
#include <vector>
#include<iostream>

using namespace std;


int getSum(vector<int> arr){
    int sum = 0;
    for(int i = 0 ; i < arr.size();i++){
        sum += arr[i];
    }
    return sum;
}


// 조합 구현하기 r개를 선택하기
vector<int> get_permutation(vector<int> arr, vector<int> out, vector<bool> visted, int depth, int r){
    // 기저 사례 ( 다 뽑았을 때 ) -> 종료조건
    if(depth==r){        
        if(getSum(out)==100){
            for(int i = 0 ; i < r; i++){
                printf("%d",out[i]);
            }
                cout << endl;
        }
            return out;
    }
// depth는 현재 채우고 있는 out 의 인덱스.
    for(int i = 0 ; i < arr.size(); i++){
        // 방문하지 않은 원소라면
        if(!visted[i]){
            visted[i] = true;
            out[depth] = arr[i];
            get_permutation(arr, out, visted, depth+1, r);
            visted[i]  = false;
        }
    }
}



// vector<int> findAnswer(vector<int> list){
//     int sum = 0;
//     vector<int> answerList;
//     do{
//         for(int i = 0; i< list.size();i++){
//             sum+= list[i];
//         }
//         if(sum == 100){
//             return 
//         }
//     }while(next_permutation(list.begin(),list.end()));
// }

int main(){
    vector<int> slaveList;
    vector<int> out;
    vector<bool> visted;

    for(int i = 0; i<9;i++){
        visted.push_back(false);
    }
    for(int i = 0; i<7;i++){
        out.push_back(0);
    }

    for(int i = 0 ; i < 9; i++){
        int slave;
        cin >> slave;
        slaveList.push_back(slave);
    }

    get_permutation(slaveList, out, visted, 0,7);

    return 1;
}