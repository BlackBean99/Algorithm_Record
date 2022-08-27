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
#include <iostream>
#include <algorithm>
using namespace std;
 

void printAll(int arr[],int i, int j){
    for (int z = 0; z < 9;z++){
        if(z != i  && z != j){ // 2명 빼고 출력
            cout << arr[z] << '\n';
        }
    }
}
// 전체 합에서 2개의 값을 빼서 100이랑 비교.
// 7개의 합으로 접근하면 어렵다!
int main(){
    int tall[10];
    int sum = 0;
    for (int i = 0; i < 9;i++){
        cin >> tall[i];
        sum += tall[i]; // 전체 합
    }
    sort(tall, tall + 9); // 미리 정렬
    for (int i = 0; i < 8; i++){
        for (int j = i + 1; j < 9;j++){
            if(sum-(tall[i]+tall[j]) == 100){ 
                // 2명을 뺀 값의 합이 100이 되면
                printAll(tall,i,j);
                return 0;
            }   
        }
    }
    return 0;
} //8 min