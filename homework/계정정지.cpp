#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>

using namespace std;

int main(){
    // 실행시작 시간 측정
    start = clock();







    
    // 실행 종료 시간 측정 
    end = clock();
    // 총 실행시간 계산
    result = (double)(end-start);
    printf("실행시간 : %f",result);
    return 0;
}