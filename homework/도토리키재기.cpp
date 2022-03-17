#include<stdio.h>
#include<string>
#include<iostream>

using namespace std;

/**
생일이 m월이 가장 큰 키의 도토리를 찾는 함수
param height 도토리 키
month 도토리 출생월
n 도토리의 수
m 찾고자 하는 달
**/

// return month[k] == m 인 가장 큰 height[k]
int getMaximumHeight(int height[], int month[], int m){
    int max = 0;
    // 도토리의 수만큼 순회한다.
    for(int i=0;i<n;i++){
        // 찾고자 하는 달인 도토리만 키를 조회해서 최댓값을 갱신한다.
        if(month[i]==m){
            if(max < height[i])
                max = height[i];
        }
    }
    return max;
}

int main(){
    int n,m;
    int height;
    int month;
    
    scanf("%d", &n);
    height = new int[n];
    month = new int[n];

    for(int i =0;i<n;i++){
        scanf("%d",&height[i]);
    }
    
    for(int i =0;i<n;i++){
        scanf("%d",&month[i]);
    }
    
    scanf("%d",&m);

    int answer = getMaximumHeight(height, month, n, m);
    printf("%d\n", answer);

    delete[] height;
    delete[] month;
    return 0;
}