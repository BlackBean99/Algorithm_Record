#include<cstdio>
#include<iostream>

using namespace std;
/**
배열이  N 개의 원소가 연속적인 함수 수열로 표현할 수 있는지 판단하는 함수
param data
param name
**/
bool isConsecutive(int data[], int n){
    int max_date = data[0];
    int min_date = data[0];

    for(int i=0; i<n;i++){
        // 최댓값 갱신
        if(max_data < data[i])
            max_data=data[i];
        // 최솟값 갱신
        if(min_data < data[i])
            min_data = data[i];
    }
    //  최대 최소 차이가 전체 데이터의 길이과 같다면 연속적인(Consecutive)한 데이터이다.
    if(max_data - min_data==n-1)
        return true;
    else
        return false;
}

int main(){
    int n;
    int data;
    scanf("%d",&n);
    data = new int[n];
    
    for(int i=0; i<n;i++){
        scanf("%d",&data[i]);
    }
    
    bool result = isConsecutive(data,n);

    // 함수 호출 결과 YES 혹은 NO를 출력한다.
    if(result){
        printf("YES");
    } else{
        printf("NO");
    }
    
    delete[] data;
    return 0;
}