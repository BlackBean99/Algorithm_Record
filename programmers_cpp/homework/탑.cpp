#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>
#include<vector>

using namespace std;

vector<int> findTargetTowers(int arr[]){
    stack<int> answer;
    // 첫번째 원소는 무조건 0이어야 한다.
    answer.push_back(0);

    for(int i =1;i<N;i++){
        for(int j=i-1;j>=0;j--){
            if(arr[i] <= arr[j]){
                // 도착한 탑의 인덱스를 저장한다.
                answer.push_back(j+1);
                break;
            }
            // 끝까지 레이저를 수신하지 못했을 때
            if(j==0){
                // 0을 데이터에 넣는다.
                answer.push_back(0);
            }
        }
    }

    return answer;
}

int main(){
    int N;

    scanf("%d\n",&N);
    int height[N];
    // 각 탑의 높이 데이터 입력
    for(int i = 0; i< N;i++){
        cin >> height[i];
    }

    vector<int> ret = findTargetTowers(height, N);

    for(int i = 0; i < ret.size(); i++){
        cout << ret[i] << " ";
    }
    return 0;
}