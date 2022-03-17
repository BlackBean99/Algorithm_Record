#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

// 평균값과 현재 index의 값의 차이중 가장 작은 값을 찾아 최신화한다.
// 비교후 가장 작은 index를 반환한다.
int findIndex(int data[], int n){
    int ret;
    int index = 0;
    int sum = 0;
    int minRet = 100000000L;
    int minIndex = n + 1;
    for(int i = 0;i<n;i++) sum += data[i];
    int avg = sum / n;

    for(int i =0; i < n; i++){
        ret = abs(data[i] - avg);
        if(minRet >= ret){
            minRet = ret;
            minIndex = i+1;
        }
    }
    return minIndex;
}

int main(){
    int n;
    int* data;
    scanf("%d", &n);
    data = new int[n];

    for(int i = 0; i < n; i++){
        scanf("%d",&data[i]);
    }
    int answer = findIndex(data, n);
    printf("%d %d\n",answer, data[answer-1]);

    delete[] data;
    return 0;
}