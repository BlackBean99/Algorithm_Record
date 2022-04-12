#include<stdio.h>
#include<string>
#include<iostream>
#include<time.h>

using namespace std;


// 발열 측정을 기다리는 학생수 N, 발열 측정기의 수m, 
// 각 측정기가 한 명을 발열 측정하는데 걸리는 시간 Time
// 모든 사람이 발열 측정을 받는데 걸리는 시간의 최솟값을 구하는 프로그램

// 입력조건 첫번째줄 N, 두번째 줄 발열 측정기의수 m, 세번째 줄에 각 발열 측정기가 측정하는데 걸리는 Time 들이 주어진다.

// 출력조건 첫ㅂ너째 줄에 발열체크에 걸리는 시간의 최솟값을 출력한다.
// 두번째 줄에 입력받은 이후부터 점수 출력까지 걸린 실행시간을 초 단위로 출력한다.


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
6 ( 검사자 수)
2 ( 측정기 수 )
7 10 ( 각 측정기 측정시간 )
먼저  

21 초에 (5개 사용 가능)
AAAAAAACCCCCCCEEEEEEE
BBBBBBBBBBDDDDDDDDDD
A 인덱스 추가, B 인덱스 추가 , C  ... E인덱스 추가/

21로 나눈 몫 = 21의 배수 - B가 빠진 인덱스
20
