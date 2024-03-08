#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;


// 중복을 제외한 숫자의 종류의 수를 계산하는 함수
// @param data
// @param name 원본 배열의 크기
// @return n 숫자의 종류의 수
int getElementTypeCount(int data[], int n){
    int countType = 0;
    // 0번 인덱스부터 
    for(int i =1;i<n;i++){
        if(data[i-1] != data[i])
            countType++;
    return countType;
}

int main(){
    int n;
    int* data;
    
    scanf("%d", &n);
    data = new int[n];

    for(int i =0;i<n;i++){
        scanf("%d",&data[i]);
    }
    
    scanf("%d",&m);

    int answer = getElementTypeCount(data, n);
    
    printf("%d\n", answer);

    delete[] data;
    return 0;
}